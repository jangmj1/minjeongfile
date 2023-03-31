package controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.productDao;

@WebServlet("/point")
public class point extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public point() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> result=productDao.getInstance().getsum(); System.out.println("result1"+result.toString());
			//result1{2023 04 01=5000, 2023 04 03=8000} => java 타입
		ObjectMapper mapper=new ObjectMapper();
		String jsonArray=mapper.writeValueAsString(result);System.out.println("result2"+jsonArray.toString());
			//result2{"2023 04 01":5000,"2023 04 03":8000}=>js 타입 !우리는 js타입의 결과값이 필요행
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpcomment=request.getParameter("mpcomment");
		int mpamount=Integer.parseInt(request.getParameter("mpamount"));
		int mno=Integer.parseInt(request.getParameter("mno"));
		
		boolean result=MemberDao.getInstance().setPoint(mpcomment, mpamount, mno);
	
		response.getWriter().print(result);
	}

}
