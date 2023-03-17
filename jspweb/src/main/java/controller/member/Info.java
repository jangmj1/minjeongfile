package controller.member;

import java.io.Console;
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
import model.dao.admindao;
import model.dto.MemberDto;
import model.dto.mpageDto;
import model.dto.pageDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리를 하기위한 준비물들 정보 가져오기
		int page=Integer.parseInt(request.getParameter("page"));
		int listsize=Integer.parseInt(request.getParameter("listsize"));
		int startrow=(page-1)*listsize;
		
		//검색
		String key=request.getParameter("key");
		String keyword=request.getParameter("keyword");
		
		//타입 1이면 전체출력 2면 검색후출력
		int type=Integer.parseInt(request.getParameter("type"));
		
		
		int totalsize=admindao.getInstance().mtotalsize();//회원의 토탈수 
			System.out.println("totalsize"+totalsize);
		int totalpage=totalsize%listsize==0?
					totalsize/listsize:totalsize/listsize+1;
		
		int btnsize=5;
		int startbtn=((page-1)/btnsize)*btnsize+1;//시작 버튼
		int endbtn=startbtn+btnsize-1;
			if(endbtn>totalpage||endbtn<btnsize) {endbtn=totalpage;}
		
		
		//로그인 or 회원번호 호출
		ArrayList<MemberDto> result=MemberDao.getInstance().getMemberList(startrow,listsize,key,keyword,type);
		System.out.println("result:"+result);
		
		//result + 페이징 처리를 같이 getWriter 하자
		mpageDto mpageDto=new mpageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
		
		
		//2. *java객.체를 js객.체로 형변환 [서로 다른 언어를 사용하니까]
		ObjectMapper mapper=new ObjectMapper();
		String jsonArray= mapper.writeValueAsString(mpageDto);
		//dao.java에서 받은 result(java) 값을  js에서 읽을수있게 로 변환하여 jsonArray 에담기
		
		System.out.println("jsonArray:"+jsonArray); // java -> js로 객체화된다
		
		//3.응답
		response.setCharacterEncoding("UTF-8");		//한글인코딩
		response.setContentType("application/json"); //전송할 데이터 타입 json=자바스크립트 객체 형식 /받을때 스크립트로 받겠다
		response.getWriter().print(jsonArray);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//------------------------------첨부파일이 있을떄!!!!!!!!!!!----------------------------------------//
				//회원가입
				//1.ajax에게 데이터 요청
				
				//준비물
					/*
					  1.프로젝트  build path에 cos.jar 추가
					  2.프로젝트 web-inf -> lib 에 cos.jar 추가
						MultipartRequest 클래스 제공
							1.요청방식 : http request
							2.저장폴더 : 1.프로젝트[git] 2.서버[워크스페이스] //수업에서는 서버에 올림
								서버폴더 경로 찾기 : request.getSession().getServletContext().getRealPath("/member/pimg");
							3.첨부파일 허용 범위 용량 [바이트 단위]
							4.첨부파일 요청 한글 인코딩
							5.첨부파일 파일명 중복일 경우 자동 뒤에 숫자 붙음
							
					
					용량
						1bit : 0,1
						1byte : 01010101	8bit --> 1byte
						1kbte : 1024byte --> 1kb
						1mbyte : 1024 kb --> 1mb
						1gbyte : 1024 mb --> 1gb
					
					 */
			
					
				//*현재 서버의 배포된 프로젝트 내 폴더 경로 찾기
			 String uploadpath=request.getSession().getServletContext().getRealPath("/member/pimg");
			 System.out.println(uploadpath);
		
		MultipartRequest multi= new MultipartRequest(
				request, 					//1.요청방식
				uploadpath,					//2.첨부파일을 가져와서 어디다가 저장할것인지 폴더
				1024*1024*10,				//3.용량 :첨부파일의 허용범위=>byte로 들어간다 1024*1024 =1메가 / 1024*1024*10 =10 메가
				"UTF-8",					//4.첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()//5.동일한 첨부파일 명이 있으면 식별이 깨진다 => 이름을 다시 만들어준다 뒤에 숫자를 붙혀서
				);
		
		//그 외 매개변수 요청[request-->multi/form 하위테그에 name 식별자 사용]
		String mid=multi.getParameter("mid");  //mid = jsp에 form하위테그내에 input테그의 name 식별자 
		String mpwd=multi.getParameter("mpwd");
		String memail=multi.getParameter("memail");
		String mimg=multi.getFilesystemName("mimg"); //첨부파일된 파일명 호출 [ .getFilesystemName] 첨부파일은getParameter 안된다
		MemberDto dto=new MemberDto(0, mid, mpwd, mimg, memail); //dto에 담아서 
		System.out.println("dto:"+dto); //콘솔창 확인
		
		boolean result=MemberDao.getInstance().signup(dto);
		response.getWriter().print(result);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//-------------------------------------------------------------------------------------------//
		
		
		
		//------------------------------첨부파일이 없을떄!!!!!!!!!!!----------------------------------------//
		//회원가입
		//1.ajax에게 데이터 요청
		
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * 
		 * String mid=request.getParameter("mid"); String
		 * mpwd=request.getParameter("mpwd"); String
		 * memail=request.getParameter("memail"); String
		 * mimg=request.getParameter("mimg");
		 */
		
		//2.dto만들기 
		/*
		 * MemberDto dto=new MemberDto(0, mid, mpwd, mimg, memail);
		 * System.out.println("dto:"+dto);
		 * 
		 * boolean result=MemberDao.getInstance().signup(dto);
		 */
		
		//2. java객체를 js객체로 형변환 할 필요없다 [서로 다른 언어를 사용하지만 문자->문자 이기때문에 ]
		/* response.getWriter().print(result); */
		//-------------------------------------------------------------------------------------------//
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정함수
		
		//1.업로드 코드 구현(첨부파일 있을때)
		String path=request.getSession().getServletContext().getRealPath("/member/pimg");
		
		//2.객체
		MultipartRequest multi=new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		String mid=(String)request.getSession().getAttribute("login");
		String mpwd = multi.getParameter("mpwd");System.out.println(mpwd);
		String newpwd = multi.getParameter("newpwd");System.out.println(newpwd);
		String memail = multi.getParameter("memail");System.out.println(memail);
		String newmimg = multi.getFilesystemName("newmimg");
		System.out.println(newmimg);
		//첨부파일
		String defaultimg=multi.getParameter("defaultimg"); System.out.println(defaultimg);
		
		//3.만약에 첨부파일이 없으면
		if(newmimg==null) {
			//기존 이미지 파일을 그래로 사용할것
			newmimg = MemberDao.getInstance().getMember(mid).getMimg();
		}
		if (defaultimg.equals("true")) {
			newmimg=null;
		}
		
		
		boolean result=MemberDao.getInstance().update(mid, mpwd, newpwd, memail, newmimg);
		response.getWriter().print(result);
		
		
		
		
		
		
		
		
		
		
		
		/* 첨부파일 없을때
		 * //회원정보수정 String mid=(String)request.getSession().getAttribute("login");
		 * System.out.println("mid:"+mid);
		 * String mpwd=request.getParameter("mpwd");System.out.println("mpwd:"+mpwd);
		 * String newpwd=request.getParameter("newpwd");System.out.println("newpwd:"+newpwd);
		 * String memail=request.getParameter("memail");System.out.println("memail:"+memail);
		 * 
		 * 
		 * boolean result=MemberDao.getInstance().update(mid, mpwd,newpwd, memail);
		 * response.getWriter().print(result);
		 */
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//회원탈퇴
		//로그인이 된 회원이 탈퇴하는것
		String mpwd= request.getParameter("mpwd");
		String mid=(String) request.getSession().getAttribute("login");
			System.out.println("mid"+mid);
			
		boolean result=MemberDao.getInstance().delete(mid,mpwd);
		response.getWriter().print(result);
	}

}
