package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;
@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Email() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 받을 회원 이메일 요청 
		String memail=request.getParameter("memail"); System.out.println(memail);
		
		//2.인증 코드 만들기
		
		String auth="";
		
		for(int i=0; i<6;i++) {//여섯자리 난수
			Random random=new Random();
			auth+= random.nextInt(10);//0~9 사이의 정수 생성
			
		}
		System.out.println("auth"+auth);
		
		//3.인증 코드를 받는 사람의 이메일로 전송
			
		/* new MemberDto().sendEmail(memail, auth); //이거랑
			
			MemberDto dto=new MemberDto();
			dto.sendEmail(memail, auth); //이거랑 같다!! */
		
		boolean result= new MemberDto().sendEmail(memail, auth);
		if(result) {
			response.getWriter().print(auth);//메일전송 성공시 인증 코드를 보낸다
		}else {
			response.getWriter().print(result);//메일 전송 실패시 펄스를 보낸다
		}
		
		//3. 인증 코드 보내기
		response.getWriter().print(auth);
				
		
		
		
		
		
		
		
		
		
		/*
		  SMTP : 간이 우편 전송 프로토콜 (simple Mail Transfer Protocol
		  메일 서버(네이버,구글, 다음) 에게 우편 전송
		 */
		
		
	
	
	}

}
