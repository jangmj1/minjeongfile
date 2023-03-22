package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.chatting;
import model.dao.MemberDao;

public class MessageDto {
	
	//private Session session; // 메시지보낸세션;
	private String frommid;		//메시지보낸회원아이디;
	private String frommimg;	//메시지보낸회원의프로필
	private String msg;			// 메시지내용;
	private String time;		//메시지보낸날짜시간;

	
	
	public MessageDto() {
		// TODO Auto-generated constructor stub
	}


	//클라이언트에게 메시지 전송할때 사용하는 생성자
	public MessageDto(Session session, String msg) {
		//this.session = session;
		
		//메시지 보낸 클라이언트 세션을 통해서 회원 아이디 얻기
		for(ClientDto dto : chatting.접속명단) {
			if(dto.getSession()==session) {
				
				this.frommid = dto.getMid();
			}
		}
		
		//보낸사람의 프로필 얻기
		
		this.frommimg = MemberDao.getInstance().getMember(this.frommid).getMimg();
		this.msg = msg;
		this.time = new SimpleDateFormat("aa hh:mm").format(new Date()) ;
	}

	/*
	 * 
	 * public Session getSession() { return session; }
	 * 
	 * 
	 * 
	 * public void setSession(Session session) { this.session = session; }
	 */



	public String getFrommid() {
		return frommid;
	}



	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}



	public String getFrommimg() {
		return frommimg;
	}



	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}


	
	
	
}
