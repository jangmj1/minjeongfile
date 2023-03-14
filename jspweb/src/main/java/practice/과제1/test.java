package practice.과제1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public test() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 int no=Integer.parseInt(request.getParameter("no"));
	 
	MemberDto result = MemberDao.getInstance().oneprint(no);
	ObjectMapper mapper=new ObjectMapper();
	String json=mapper.writeValueAsString(result);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
