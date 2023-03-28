package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.productDao;
import model.dto.productDto;

@WebServlet("/product/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public info() {
        super();
    }
    ObjectMapper mapper=new ObjectMapper();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double 동= Double.parseDouble(request.getParameter("동")) ;	System.out.println(동);
		double 서= Double.parseDouble(request.getParameter("서")) ;	System.out.println(서);
		double 남= Double.parseDouble(request.getParameter("남")) ;	System.out.println(남);
		double 북= Double.parseDouble(request.getParameter("북")) ;	System.out.println(북);
    	
		ArrayList<productDto> result=productDao.getInstance().getproductList(동,서,남,북);
		
		String jsonarray=mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*------------------------------------------common.jar 사용시(첨부파일 여러개)-----------------------------------------------	*/
	request.setCharacterEncoding("UTF-8"); //*요청 한글 타입
		
	//1.다운로드할 서버 경로
	String 경로=request.getSession().getServletContext().getRealPath("/product/pimg");
	System.out.println(경로);
	//2.해당 경로의 파일/폴더 객체화(준비물)=>왜시킴? 밑에 파일저장소.setRepository(저장경로객체);	대입하기위해서!!
	File 저장경로객체=new File(경로);
	
	//3.파일 저장소 위치를 대입
	DiskFileItemFactory 파일저장소=new DiskFileItemFactory();
	파일저장소.setRepository(저장경로객체);			//setRepository담을수 있는 자료형이 File =>2번준비물필요 (path와 동일)
	파일저장소.setSizeThreshold(1024*1024*10);	//파일 저장소에 저장할수있는 최대용량 범위
	파일저장소.setDefaultCharset("UTF-8");		//파일저장소 한글 인코딩
	
	//4.파일 업로드 객체만들기
	ServletFileUpload 파일업로드객체=new ServletFileUpload(파일저장소);
	
	
	try {
		//5.매개변수 요청해서 리스트에 담기 [무조건 예외 처리 발생]
		List<FileItem> 파일아이템목록= 파일업로드객체.parseRequest(request);//파일업로드객체를 요청해서 리스트에 담아서 그걸 반복문 돌릴예정
			//db처리하기 위해 분리한것뿐
		List<String>일반필드목록=new ArrayList<>();
		List<String>파일필드목록=new ArrayList<>();
		
		
		//6.
		for(FileItem item : 파일아이템목록) {//요청된 모든 매개변수들의 반복문 돌려서 확인
			if(item.isFormField()) {
				//.isFormField() : 첨부파일이 아니면 true 첨부파일이면 false
				System.out.println("[첨부파일이 아닌 필드명]:"+item.getFieldName());//필드의 이름
				System.out.println("[첨부파일이 아닌 필드의 값:]"+item.getString());//필드의 입력값
				일반필드목록.add(item.getString());//리스트 저장
			}else {
				System.out.println("[첨부파일인 필드명]:"+item.getFieldName());//input name
				System.out.println("[첨부파일인 필드의 파일명]:"+item.getName());
								//파일일 경우엔 파일의 이름을가져옴 item.getString 쓰지말것(사진의 값이나온다 byte로,우리가 필요한건 파일의 이름) 
				
				//9.첨부파일의 이름을 식별 이름으로 변경(
					//1. 파일명의 공백이 존재하면 -로 변경("기존문자", "새로운문자") 문자열 치환함수)
					//2.UUID : 범용 고유 식별자[중복이 없는 식별자 만들기,자바에서 제공해준다]
					//최송 식별 파일명 : UUID 파일명 (UUID 띄어쓰기 파일명)
					/*cos에서는 new DefaultFileRenamePolicy() 사용하여
						이름이 동일하면 숫자 붙혀주는게잇찌만 commons에서는 없어서 직접 만들어줘야한다*/
				String filename=UUID.randomUUID()+" "+( item.getName().replaceAll(" ", "-") );
				
				파일필드목록.add(filename);//첨부된 파일의 이름을 요청해서 리스트에 저장시킴(db처리 목적)
				
				//7.저장할 경로 +/+파일명의 파일을 객체화(7,8실제 업로드)
				File 업로드할파일=new File(경로+"/"+filename);//
				//8.해당파일 객체 저장
				item.write(업로드할파일); //write는 담는 자료형이 또 File 그래서 업로드할피일로 파일화시킴 */
				
			}
			
		} 
		System.out.println(일반필드목록.toString()); System.out.println(파일필드목록.toString());
		
		//제품등록한 회원번호
		int mno=MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		
		//dto구성
		productDto dto=new productDto(일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt(일반필드목록.get(2)),
				일반필드목록.get(3), 일반필드목록.get(4),mno,파일필드목록);
		System.out.println("dto:"+dto.toString());
		
		//dao
		boolean rusult= productDao.getInstance().write(dto);
		response.getWriter().print(rusult);
	} catch (Exception e) {	System.out.println(e); System.out.println("저장실패");}
		
	
	
	
	/*------------------------------------------cos.jar 사용시(첨부파일 한개)-----------------------------------------------	*/
		/*
		String path=request.getSession().getServletContext().getRealPath("/product/pimg");
		System.out.println(path);
		MultipartRequest multi=new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		//첨부파일 1개 이름 가져오기 multiple x
		String pfile=multi.getFilesystemName("pfile");
		
		//첨부파일 여러개 이름 가져오기 1 multiple x
		String pfile1=multi.getFilesystemName("pfile1");
		String pfile2=multi.getFilesystemName("pfile2");
		String pfile3=multi.getFilesystemName("pfile3");
		
		//첨부파일 여러개 이름 가져오기 2 multiple
		String pfiles1=multi.getFilesystemName("pfiles");
			System.out.println(pfiles1);	
				//!문제 : 사진은 3개가 들어오지만 이름은 하나만 들어온다
		
		//첨부파일 여러개 이름 가져오기 2-2 multiple
			//multiple input 에 등록된 여러 사진들의 이름 가져오기 불가능[cos.jar 제공 x]
			//다른 라이브러리 사용
		Enumeration pfiles2=multi.getFileNames(); // multiple
		while (pfiles2.hasMoreElements()) {
			//해당 목록에 요소가 존재하면 true/ 아니면 false
			String s=(String)pfiles2.nextElement();
					System.out.println("s:"+s);
					//!문제 : 얘도 위에꺼처럼 결국 해결이 안됨 ==> 즉 cos.jar는 multiple 썼을때 이름을 못때온다!!!!
		}
		
		String pname=multi.getParameter("pname");					System.out.println(pname);
		String pcomment=multi.getParameter("pcomment");				System.out.println(pcomment);
		int pprice=Integer.parseInt(multi.getParameter("pprice")) ;	System.out.println(pprice);
		String plat=multi.getParameter("plat");						System.out.println(plat);
		String plng=multi.getParameter("plng");						System.out.println(plng);
		
		productDto dto=new productDto(pname, pcomment, pprice, plat, plng);
		boolean result=productDao.getInstance().write(dto);
		response.getWriter().print(result);
		*/
	
	}
	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
