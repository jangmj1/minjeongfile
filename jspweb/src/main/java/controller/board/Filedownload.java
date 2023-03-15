package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filedownload")
public class Filedownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    public Filedownload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.다운로드할 파일명 요청
		request.setCharacterEncoding("UTF-8");
		String bfile=request.getParameter("bfile");
		System.out.println("bfile:"+bfile);
		
		
		//2.파일 다운로드
			//1.다운 로드할 파일의 경로
		//String path=request.getSession().getServletContext().getRealPath("/board/bfile");
			//System.out.println("경로:"+path);
			
			//2.다운로드할 폴더경로를 찾았으면 그안의 파일경로를 찾자 
		String path=request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			System.out.println("경로:"+path);
			
			//3.파일 클래스 [ 다양한 메소드 제공 ]
		File file=new File( path);
		//해당 파일 경로를 파일 객체화시킴 (자바화 시킴) *path는 스트링이기때문에 length를 사용하면 바이트의 크기를 알수가없다 ! 
			//그래서 파일클래스를 사용하여 변환시킨다 , 파일 클래스에 length를 사용하면 바이트크기를 알수가있음!!
		
			//3. http 다운로드 형식[프론트엔드] =각 브라우저 제공 
		response.setHeader(// HTTP 에 header 메소드(http 옵션 정보 설정)
					"content-Disposition", // 각 브라우저 마다 다운로드 형식 HTTP실어서 입션에 포함해서 보내기
					"attachment;filename="+URLEncoder.encode(bfile,"UTF-8")
					//다룬로드시 파일명에 표시되는옵션 [ 한글 파일 인코 딩]
					//URLEncoder.encode( 파일명 , "UTF-8") : url(통신주소)의 한글 인코딩
				);
		
			//4.파일 스트림[바이트단위] *원래는 예외처리가 무조건 발생하는데 자동으로 서블렛에선 예외처리를 안해도 됨
				//1.파일 객체의 바이트를 모두 읽어온다.
		
					//1.해당 경로[파일] 파일.입.력. 스트림 객체 만들기 =>FileInputStream 은 서버와 유저사이에 도로를 깔아주는것! 스트림은 byte단위로만 왔다갔다 가능하다
				FileInputStream fin=new FileInputStream(file); //요청한 파일이 들어올수 스트림이라는 도로깔기
				
					//2.파일 입력 스트림 객체에서 꺼내올 바이트들을 저장할 바이트 배열 준비[선언]
				
					//바이트 배열 길이 = 파일의 길이 [여러개의 바이트를 담기위해 배열로만든다 예)파일 하나에 200바이트면 200개의 바이트를 담는 배열저장소가 필요함]
				byte[] bytes=new byte [ (int) file.length() ]; 
							// new byte[ int가 들어가는자리 ]
									
				
					//3.파일입력스트림객체에서 read() : 해당 파일을 바이트로 읽어오는 함수
				fin.read(bytes); //fin
		
				//2. 읽어온 바이트를 모두 출력한다.[클라이언트에게 응답 ]
					//1.response응답 객체에서 출.력 스트림을 호출하고 파일 .출.력.스트림 객체를 만들자
					//response.getOutputStream() : http 스트림 단위[바이트] 전송
				BufferedOutputStream fout=new BufferedOutputStream(response.getOutputStream());//요청한 유저 나갈수있는 스트림이라는 도로깔기
				
				
					//2. 파일 입력 스트림 객체에서 읽어온 바이트들![바이트배열]을 출력한다 
					//파일 출력 스트림 객체에서 .write 를 쓰게되면 : 해당 배열내 바이트들을 출력하는,내보내는 함수다
				fout.write(bytes); // ------->response.getOutputStream() 로 나간다
				
				//3.스트림 닫기 [용량이 크기떄문에 가비지대신 직접 스크림 닫기]
				fin.close();	//파일 입력 스트림 객체 닫기(초기화)
				fout.flush();	//파일 출력 스트림 객체 내 스트림 메모리 초기화
				fout.close();	//파일 출력 스트림 객체 스트림 닫기
				
				
		
			
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
