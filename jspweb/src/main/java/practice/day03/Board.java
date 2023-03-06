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
 * Servlet implementation class board
 */
@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
    }
    //등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	//2.매개변수 요청 [AJAX DATA 속성에서 보내준 매개변수 이름]
    	String content=request.getParameter("content");
    		System.out.println("content"+content);
    	String writer=request.getParameter("writer");
    		System.out.println("writer"+writer);
    		
    	//3.dto 객체                  int의 기본값:o          객체 필드의 null
    		BoardDto boardDto=new BoardDto(0, content, writer, null);
    		
    	//4. DAO 호출해서 결과 저장
    		boolean result=BoardDao.getInstance().onwrite(boardDto);
    		
    	//5.dao 결과인 true,false 데이터를 response
    		response.getWriter().print(result);
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   //1.응답데이터 한글 인코딩
	      response.setCharacterEncoding("UTF-8");
	      //2.DAO 호출해서 모든 게시물을 반환해서 저장
	      ArrayList<BoardDto> result=BoardDao.getInstance().onlist();
	      //3.Json(js객체) 형식의 문자열로 변환
	      ObjectMapper mapper=new ObjectMapper();//1.jackson 라이브러리에서 제공하는 클래스
	      
	      String jsonArray=mapper.writeValueAsString(result);//2.DAO 로 부터 받은 리스트를  json형식의 문자열 변환하기
	         System.out.println("jsonarray"+jsonArray);
	      //4.응답
	      response.setContentType("application/json");
	      response.getWriter().print(jsonArray);
	      
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		System.out.println("수정할 번호:"+bno);
		
		//수정할 게시물 내용
		String newContent=request.getParameter("newContent");
		System.out.println("수정할내용:"+newContent);
		
		//dao호출해서 결과 얻기
		boolean result=BoardDao.getInstance().onupdate(bno, newContent);
		
		//결과 응답하기
		response.getWriter().print(result);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("삭제");
	 //삭제할 게시물 요청
	 int bno=Integer.parseInt(request.getParameter("bno")) ;
	 boolean result= BoardDao.getInstance().Delete(bno);
	
	 //dao 한테 얻은 결과를 응답하기 js한테 보낸다
	 response.getWriter().print(result);
	 
	 System.out.println("삭제할번호요청"+bno);
	 
	
	}

}
