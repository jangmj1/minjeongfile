package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Api1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.공공데이터 포털에서 신청한 데이터 가져오기[안산시 전기차 충전소 현황]
			//URL 클래스 사용
			//1. .openStream()으로 가져오기 : 해당 객체의 연결된 url 스트림 제공 함수
		//URL url=new URL("URL주소넣기");
		URL url=new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=cO9iM%2FZvQcqC9uLrdgNR0tPyBU3%2Bjxi9Z0u2x%2FNuYg%2FS2C4KCe0M5mlbabI9mrmILwew3%2FvR7M4YWaZ9IT2udw%3D%3D");
		
		//2.해당 url의 데이터를 byte단위로 읽어오기위한 Stream객체 만들기
		InputStream inputStream=url.openStream();
			//=>openStream 반환 타입이 InputStream 임 =>이렇게 썼더니 한글이 깨졌다 그래서 InputStreamReader 로 씌었떠니 얘는 char밖에 못읽어..그래서BufferedReader로 또덮음
		InputStreamReader reader=new InputStreamReader(url.openStream(),"UTF-8");
		BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		//BufferedReader=>스트링으로 읽어주는 기능이있다 ! InputStreamReader=>char로 읽어주는 기능이있다 ! InputStream=> byte로 읽어주는 기능이있다  우리가 필요한건 스트링 
		
			//*
			byte[] array1=new byte[100000];
			char[] array2=new char[100000];
		
		//실제로 읽기->스트림을 부터 바이트 읽어오기
		inputStream.read(array1);	//바이트byte 배열로 읽어오기
		reader.read(array2);		//문자byte 배열로 읽어오기
		String result=bf.readLine(); 				//모든 바이트 읽은후 문자열 string으로 반환
		System.out.println(array2);
		System.out.println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
