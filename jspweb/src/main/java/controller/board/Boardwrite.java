package controller.board;

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

import model.dao.MemberDao;
import model.dao.boardDao;
import model.dto.boardDto;

@WebServlet("/board/info")
public class Boardwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Boardwrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type= Integer.parseInt(request.getParameter("type")) ;
		if(type==1) {
			//dao 처리
			ArrayList<boardDto>result= boardDao.getInstance().getboardList();
			//형변환
			ObjectMapper mapper=new ObjectMapper(); //java형태를 js형태로 바꿔주는거
			String jsonArray =mapper.writeValueAsString(result); //java형태인 result값을 mapper해줌(js로)
			//응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}else if (type==2) {
			int bno=Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno:"+bno);
			
			//dao 처리
			boardDto result=boardDao.getInstance().getBoard(bno);
			//형변환
			ObjectMapper mapper=new ObjectMapper();
			String jsonArray= mapper.writeValueAsString(result);
			//응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//첨부파일 업로드할 파일의 저장 위치
			//유저가 깃으로 들어오는게 아니고 서버로 들어온다. 배포된 프로젝트는 서버에 있고 유저는 서버에있는 프로젝트를 사용
		
		//2.경로를 찾아주기
		String path=request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("path:" + path);//path는 서버의 경로! 서버의 경로에 유저가 올린 파일들이 올라간다!
		
			//3.경로를 가지고 파일을 복사함
			MultipartRequest multi= new MultipartRequest(
					request, 					//1.요청방식
					path,				 		//2.첨부파일을 가져와서 어디다가 저장할것인지 폴더
					1024*1024*10,				//3.용량 :첨부파일의 허용범위=>byte로 들어간다 1024*1024 =1메가 / 1024*1024*10 =10 메가
					"UTF-8",					//4.첨부파일 한글 인코딩
					new DefaultFileRenamePolicy()//5.동일한 첨부파일 명이 있으면 식별이 깨진다 => 이름을 다시 만들어준다 뒤에 숫자를 붙혀서
					);
			System.out.println("multi"+multi);
		//---------------여기까지가 업로드이다 여기서 한번 끊고 확인할것---------------------
			
			//request.getParameter("") ""안에 객체명의 필드명 쓸것
		    //String cno=multi.getParameter("cno");"클래스명이 아닌 name 명 쓸것"
		 int cno=Integer.parseInt(multi.getParameter("cno"));  System.out.println("cno"+cno);
		 String btitle=multi.getParameter("btitle");System.out.println("btitle"+btitle);
		 String bcontent=multi.getParameter("bcontent");System.out.println("bcontent"+bcontent);
		 String bfile=multi.getFilesystemName("bfile"); //실제 파일 이름만! 가져온다
		 //String bfile=multi.getParameter("bfile");System.out.println("bfile"+bfile); = > 이렇게 하면 null나옴 파일을 못가져온다
		 	//------------확인--------------
		 
		 //회원제 게시판[로그인된 회원의 mno필요!!]
		 String mid=(String)request.getSession().getAttribute("login"); //mid
		 
		 //mid를 mno로 만들기 이건 dao만 할수있따
		 int mno=MemberDao.getInstance().getMno(mid);
		 //dto 만들고
		 if(mno<=0) {
			 response.getWriter().print("false"); //??
		 }
		 
		 boardDto dto=new boardDto(btitle, bcontent, bfile, mno, cno);
		 System.out.println(dto); //toString 어디다씀???
		 //dao 처리하고
		 boolean result=boardDao.getInstance().bwrite(dto);
		 //응답하기
		 response.getWriter().print(result);
	
	
	
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
