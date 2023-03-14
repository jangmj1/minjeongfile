package practice.과제1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/hisystem")
public class hiSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public hiSystem() {
        super();

    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MemberDto>list=MemberDao.getInstance().hiprint();
		
		ObjectMapper mapper=new ObjectMapper();//자바객체를 js객체로 형변환 왜? 서로 다른 언어니깐
		String json=mapper.writeValueAsString(list);
		//dao.java에서 받은 결과값을 js에서 읽을수있게 변환하면 json담기
		
		
		response.setCharacterEncoding("UTF-8");//한글인코딩
		response.setContentType("application/json");//객체만들어줌
		response.getWriter().print(json);//결과값 응답
		
		
	}

	//1.인사등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uploadpath=request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println(uploadpath);
		MultipartRequest multi=new MultipartRequest(
				
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				
				);
		
		String mname=multi.getParameter("mname");       System.out.println("mname"+mname);
		String mrank=multi.getParameter("mrank");
		String employment=multi.getParameter("employment");
		String division=multi.getParameter("division");
		String idate=multi.getParameter("idate");
		String mimg=multi.getFilesystemName("mimg");
		String edate=multi.getParameter("edate");
		String resign=multi.getParameter("resign");System.out.println("resign"+resign);
		
		
		
		MemberDto dto=new MemberDto(0, mimg, mname, mrank, employment, division, idate, edate, resign);
				
		boolean result= MemberDao.getInstance().signup(dto);//DAO에 결과값 받은후 저장
		//응답
		response.getWriter().print(result);
	
		
		
		
		
		
		
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String uploadpath=request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println(uploadpath);
		MultipartRequest multi=new MultipartRequest(
				
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				
				);
		
		String newmname=multi.getParameter("newmname");        System.out.println("newmname"+newmname);
		String newmrank=multi.getParameter("newmrank");
		String newemployment=multi.getParameter("newemployment");
		String newdivision=multi.getParameter("newdivision");
		String newidate=multi.getParameter("newidate"); System.out.println("newidate"+newidate);
		String newmimg=multi.getFilesystemName("newmimg");
		String newedate=multi.getParameter("newedate");
		String newresign=multi.getParameter("newresign");
		
		int no=Integer.parseInt(multi.getParameter("no"));
		System.out.println("no:"+no);		
		
				
		  boolean result=MemberDao.getInstance().newupdate(newmname, newmrank,
		  newemployment, newdivision, newidate, newmimg, newedate, newresign, no);
		  response.getWriter().print(result);
		 
		
		
		
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("11:"+request.getParameter("del_no"));
		int no =Integer.parseInt(request.getParameter("del_no")); 
		
		boolean result=MemberDao.getInstance().del(no);
		response.getWriter().print(result);
	}

}
