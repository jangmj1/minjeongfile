package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public vote() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String v_jumin=request.getParameter("v_jumin");
		String v_name=request.getParameter("v_name");
		String m_no=request.getParameter("m_no");
		String v_time=request.getParameter("v_time");
		String v_area=request.getParameter("v_area");
		String v_confirm=request.getParameter("v_confirm");
		
		Dto dto=new Dto(m_no, v_jumin, v_name, v_time, v_area, v_confirm);
		Dao dao=new Dao();
		boolean result=dao.vote(dto);
		if(result) {response.sendRedirect("/HRD_3/index.jsp");}
		else {response.sendRedirect("/HRD_3/vote.jsp"); }
		
		
	}

}
