package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class mconfirm
 */
@WebServlet("/mconfirm")
public class mconfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public mconfirm() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String mid= request.getParameter("mid");
		
		//2.dao에게 전달하고 결과받기
		boolean result=MemberDao.getInstance().idCheck(mid);
		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


}
