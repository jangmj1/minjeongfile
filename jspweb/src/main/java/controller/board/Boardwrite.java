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
import model.dto.pageDto;

@WebServlet("/board/info")
public class Boardwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Boardwrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type=Integer.parseInt(request.getParameter("type")) ;
		if(type==1) {//1.전체출력
			
			//-------------------------카테고리별 출력--------------------------
			//1. 카테고리 매개변수 요청 [cno]
			int cno=Integer.parseInt(request.getParameter("cno"));
			
			//--------------------------검색처리---------------------------------
			String key=request.getParameter("key");			///. 
			String keyword=request.getParameter("keyword");
			
			//------------------------------page처리----------------------------
			//1.현재페이지요청,2.현재페이지[게시물시작,게시물끝]
			int page=Integer.parseInt(request.getParameter("page")); //page가져오기
			int listsize=Integer.parseInt(request.getParameter("listsize")); //1page당 출력되는 게시글의 수
			int startrow= (page-1)*listsize;//해당 페이지에서의 게시물 시작 인!덱!스!번호 구하기
					
					/*
						총 게시물 수 =10개 --> 패이지당 표시할 게시물수 : 3개
						 ※즉 총 페이지 수 4페이지, (123/456/789/10) 
						 	
						 1.페이지별 게시물 시작 번호 찾기
						 	1페이지 요청-> (1-1)*3 =0
						 	2페이지 요청-> (2-1)*3 =3
						 	3페이지 요청-> (3-1)*3 =6
						
						2.시작버튼,마지막버튼
							7페이지일경우
									s		e
							1page-->1,2,3,4,5
							2page-->1,2,3,4,5
							3page-->1,2,3,4,5
							4page-->1,2,3,4,5
							5page-->1,2,3,4,5
							6page-->6,7
							7page-->6,7
						
					 */
			
			//----------------------------------page버튼만들기----------------------
			//1.전체 페이지수[총게시물수/페이지당 표시수] 2. 페이지 표시할 최대 버튼수 3.시작버튼번호
				
	 		/*
	 		1.전체 페이지수[총게시물수/페이지당 표시수]
	 		  	총 레코드수/페이지당 표시게수
		 			1.나머지가 없으면 => 몫
		 			2.나머지가 있으면 => 몫 + 1 (10/3=3.333 =>4페이지)
			*/
				//1.검색이 없을때
			//int totalsize=boardDao.getInstance().gettotalsize(); //글의 총개수
			
				//2.검색이 있을때
			int totalsize=boardDao.getInstance().gettotalsize(key,keyword,cno); // 글의 모든 총 갯수를 구하는 함수
			int totalpage=totalsize%listsize==0? //=> 7페이지(버튼): 3항 연산자 사용 글의총갯수에서 3을 나눠서 나머지가없으면
					totalsize/listsize: //글의 총갯수 나누기 3 
					totalsize/listsize+1; //글의 총갯수 나누기 3+1
				//이제 나온  totalpage 값을 ajax로 보내기 위해 result 가 포함된 pageDto하나를 더 만듬
			
			//2. 페이지 표시할 최대 버튼수
			int btnsize=5;//최대 페이징 버튼 출력수
			int startbtn=((page-1)/btnsize) * btnsize + 1; //시작번호 6페이지가 되면 6,7 만 떠야한다
				/*
				 	1page : 1-1/5 *5+1		-> 0*5+1		-> 1
				 	2page : 2-1/5 *5+1		-> 0*5+1		-> 1
				 	3page : 3-1/5 *5+1		-> 0*5+1		-> 1
				 	4page : 4-1/5 *5+1		-> 0*5+1		-> 1
				 	5page : 5-1/5 *5+1		-> 0*5+1		-> 1
				 	6page : 6-1/5 *5+1		-> 1*5+1		-> 6
				 	7page : 7-1/5 *5+1		-> 1*5+1		-> 6
				 */
			int endbtn=startbtn+btnsize-1;//끝번호 1+5-1=5 단 마지막 페이지보다 커지면안된다
				if(endbtn>totalpage) {endbtn=totalpage;}
				/*
				 	1page : 1+5-1	-> 5
				 	2page : 1+5-1	-> 5
				 	3page : 1+5-1	-> 5
				 	4page : 1+5-1	-> 5
				 	5page : 1+5-1	-> 5
				 	6page : 6+5-1	-> 10	->만약에 endbtnrk가 totalpage 보다 클경우 10=7 ->7
				 	7page : 6+5-1	-> 10	->만약에 endbtnrk가 totalpage 보다 클경우 10=7 ->7
				 	
				 */
				
			
				//dao 처리(한페이지당 페이지 출력되는 함수)-검색이 없을때
			//ArrayList<boardDto>result= boardDao.getInstance().getboardList(startrow,listsize);
			
			//dao 처리(한페이지당 페이지 출력되는 함수)-검색이 있을때
			ArrayList<boardDto>result= boardDao.getInstance().getboardList(startrow,listsize,key,keyword,cno);
			
			//totalpage+result 같이 보내버리기
				//page Dto 만들기(pageDto 안에 result값을 같이 포함시켜서 새로만듬)=>startbtn,endbtn 추가해서 생성자 다시만듬 ㅜㅜ
			pageDto pagedto=new pageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			//----------------------------------------------------------------------------
			
			
			
			
			
			
			
			
			//형변환
			ObjectMapper mapper=new ObjectMapper(); //java형태를 js형태로 바꿔주는거
			String jsonArray =mapper.writeValueAsString(pagedto); //java형태인 result값을 mapper해줌(js로)
			//응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}else if (type==2) {//2.개별출력
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
			 response.getWriter().print("false");
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
