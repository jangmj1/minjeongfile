package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class 과제
 */
@WebServlet("/Ex2_2")
public class Ex2_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Dto_2> list2=Dao.getInstance().list2();
		 
		 ObjectMapper objectMapper= new ObjectMapper();
		 
		 String json=objectMapper.writeValueAsString(list2);
		 
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("application/json"); //?
		 response.getWriter().print(json);
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JS요청 객체
		request.setCharacterEncoding("UTF-8"); //한글로 받기
		System.out.println("ㅎㅎㅎ");
		
		//2.
		String data11=request.getParameter("data11");
		String data12=request.getParameter("data12");
		Double data13=Double.parseDouble(request.getParameter("data13"));
		int data14=Integer.parseInt(request.getParameter("data14")) ;
		String data15=request.getParameter("data15");
		String data16=request.getParameter("data16");
		boolean data17=Boolean.getBoolean(request.getParameter("data17")) ;
		String data18=request.getParameter("data18");
		String data19=request.getParameter("data19");
		
		Dto_2 dto_2=new Dto_2(data11, data12, data13, data14, data15, data16, data17, data18, data19);
		
		boolean result=Dao.getInstance().setData_2(dto_2);
		
		response.setCharacterEncoding("UTF-8");//한글로 리턴하기
		
		response.getWriter().print(result);
		
		
		
		
	}

}
