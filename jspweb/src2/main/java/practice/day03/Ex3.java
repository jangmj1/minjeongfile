package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3")// <--해당 자원(클래스)에 url 정의 , localhost:8080/jspweb/Ex3 

public class Ex3 extends HttpServlet {//<-- http HttpServlet 클래스에게 상속
	private static final long serialVersionUID = 1L;
    public Ex3() {
        super();
    }
    
    
    //2. Post 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Post 메소드에서 통신 받았습니다");
    }
    //1. get 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 메소드에서 통신 받았습니다");
		
		//응답매개변수를 한글 인코딩
		response.setCharacterEncoding("UTP-8");
		
		//2.dao 호출해서 모든 게시물을 반환해서 저장
		ArrayList<BoardDto> result=BoardDao.getInstance().onlist();
		
		//3.json 형식의 문자열로 변환
		ObjectMapper mapper=new ObjectMapper(); //1.jackson 라이브러리에서 제공하는 클래스
		String jsonArray= mapper.writeValueAsString(result); //2.dao로 부터 받은 리스트를 json형식의 문자열로 변환
		
		//4.응답
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}


	//3. Put 메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Put 메소드에서 통신 받았습니다");
	}

	//4. Delete 메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete 메소드에서 통신 받았습니다");
	}

}
