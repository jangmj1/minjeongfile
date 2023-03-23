package 팀프로젝트.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;
import 팀프로젝트.model.jsp_project_dao;
import 팀프로젝트.model.jsp_project_dto;
@WebServlet("/maininfo")
public class maininfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public maininfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath=request.getSession().getServletContext().getRealPath("/팀프로젝트/img");
		
		MultipartRequest multi=new MultipartRequest(
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		String mname=multi.getParameter("mname");				System.out.println(mname);
		String mid=multi.getParameter("mid");					System.out.println(mid);
		String mpwd=multi.getParameter("mpwd");					System.out.println(mpwd);
		String mresidence=multi.getParameter("mresidence") ;	System.out.println(mresidence);
		String memail=multi.getParameter("memail");				System.out.println(memail);
		String mmw= multi.getParameter("mmw") ;					System.out.println(mmw);
		String mphone=multi.getParameter("mphone") ;			System.out.println(mphone);
		String mimg=multi.getFilesystemName("mimg");			System.out.println(mimg);
		
		jsp_project_dto dto=new jsp_project_dto(0, mname, mid, mpwd, mresidence, memail, mmw, mphone, mimg);
		boolean result=jsp_project_dao.getInstance().signup(dto);
		
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
