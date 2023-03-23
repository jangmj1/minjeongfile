package controller.admin;

import java.io.IOException;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MessageDto;

 // url 매개변수받을때 : /경로/{매개변수1}/{매개변수2}				-->@PathParam("경로상의매개변수명") 타입 변수명
		/*
		 	/jspweb/chatting/sksk1277	->js클라이언트소켓
		 	/jspweb/chatting/{mid}		->java @ServerEndpoint {mid}안에 sksk1277라는걸 넣고
		 	 @PathParam("mid") String (매개변수)
		 	 매개변수=sksk1277
		 */



 // url 매개변수받을때 : /경로?매개변수=데이터 & 매개변수명2=데이터		-->request.getParameter("매개변수명")



@ServerEndpoint("/chatting/{mid}")// 1.해당 클래스를 서버소켓[종착점] 만들기 
public class chatting {
	
	//**접속한 클라이언트 명단[목록] 클라이언트 여러개 저장
	public static ArrayList<ClientDto> 접속명단=new ArrayList<>();
	
	//2.클라이언 소켓이 접속 했을때 실행되는 메소드/함수
	@OnOpen	//session 접속한 클라이언트소켓 객체 //서버엔드포인트의 url 매개변수 [@PathParam] 가져오기
	public void OnOpen(Session session,@PathParam("mid") String mid ) throws Exception { //OnOpen 이름 아무거나사용가능 !session = 접속한 클라이언 소켓객체
				
		//접속한 클라이언트 소켓들을 보관하기위해 필드만들자 ! 왜보관함? 유재석이메세지를 보내면 같이 접속한 강호동페이지에도 메세지가 나와야하니까
		ClientDto clientDto=new ClientDto(session, mid);
		접속명단.add(clientDto);
		System.out.println(접속명단.toString());
		
		//새롭게 접속한 클라이언트를 모든 사람들에게 알림메세지보내기(누가 입장하였습니다)
		onMessage(session,"enter");
		
	}
	@OnClose	//클라이언트 소켓이 접속이나갔을때 (f5눌렀을때)
	public void onclose(Session session) throws Exception {
		System.out.println("클라이언트가 나갔습니다");
		
		//접속끊긴 세션의 dto찾아서 제외
		for(ClientDto dto:접속명단) {
			if(dto.getSession()==session) { //주소값이 같으면
				
				접속명단.remove(dto); //접속명단에서 제외를 시켜야함 
				
				//연결이 끊긴 클라이언트 소켓을 모든 접속명단에게 알림 메시지보내기
				//1.문자열 타입의 JSON형식 직접 작성하기[VS ObjectMapper]
					//{"필드명1":"데이터1","필드명2":"데이터2"}
				String msg="{\"type\":\"alarm\",\"msgbox\":\""+dto.getMid()+"님이 채팅방에 나갔습니다.\"}";
				onMessage(session, msg);//나갔다는 메세지
				
				//나간 사람의 소켓을 모든 접속 명단에게 목록알림 메시지 보내기
				onMessage(session, "enter");//명단
				break;//나간사람 찾았으면 한번만 실행하면되기때문에 브레이크걸자
			}
		}
	}
	//3.클라이언트 소켓이 메시지를 보냈을때[서버가 메세지받기]
	@OnMessage//[필수인수 ! 누가 session , 어떤내용을 msg ] session과 memberInfo 는 다른것  session는 pc, memberInfo 회원정보
	public void onMessage(Session session,String msg) throws Exception {
		System.out.println("클라이언트 웹 소켓이 메시지를 보냈따.[서버가 메세지를 받았다.]");
		System.out.println(msg);//클라이언트가 보낸 메세지를 받음
		//2.접속명단 알림
		ObjectMapper mapper=new ObjectMapper();
		String json=null;
		if(msg.equals("enter")) {//엔터가 들어올리가 없다
			//회원명단[이미지랑 아이디 포함된 회원 리스트를 생성]
			ArrayList<MessageDto>list=new ArrayList<>();
			for(ClientDto dto:접속명단) {//현재 접속된 접속명단의 회원정보객체를 만들어서 리스트에 담는다
				list.add(new MessageDto(dto.getSession(), null));//명단안에 있는dto다 만들기
			}
			json=mapper.writeValueAsString(list);//전체회원정보의 객체가 담긴 list를 json에 담기
		}else {
			//1.메시지
			//메시지 형식 구성
			MessageDto messageDto=new MessageDto(session, msg);//보낸사람의 dto한개만들고
			 json=mapper.writeValueAsString(messageDto);
		}
		
		//메시지받는프로그램[js]:json 으로 형변환 *Session 객체를 json형식으로 변화 불가능
		
		
		
		System.out.println(json);
			
		
		
		//4.클라이언트(보낸사람)로 메세지를 보내야함
		//현재 서버 소켓과 연결된 클라이언트 소켓 모두에게 서버가 받은 내용물을 전달
		for(ClientDto dto : 접속명단) {
											//json형식[모양]의 타입은 문자열로
			dto.getSession().getBasicRemote().sendText(json); //--->클라이언트 소켓.OnMessage
		}
		
	}

}
