package Day06;

import java.io.FileOutputStream;
import java.util.Scanner;


public class Ex3_문자열2 {
	public static void main(String[] args) throws Exception{
		
		while (true) { //문자 무한으로 이어쓰기
		//1.문자열 입력받기
		Scanner scanner=new Scanner(System.in);	//1.입력객체
		System.out.println("문자열을 입력해주세용");	
		String input=scanner.nextLine()+"\n";		//2. 입력객체가 제공하는 메소드 (키보드로 부터 받은걸 가져와서 변수에 저장)
							//nextLine()는 엔터는 문자로 못받는다 엔터쓰는것 자체가 문자쓰는것 끝났다 라고 인식하기때문
		System.out.println(input);
		
		
		//2.문자열 파일에 저장[자바외 키보드/파일/네트워크 등등 통신할때 무조건 바이트단위]
		FileOutputStream fout=new FileOutputStream("c:/java/text.txt",true); 
		//FileOutputStream("파일경로") : 파일 쓰기 클래스
		//FileOutputStream("파일경로",true) : 파일 이어쓰기
		
		fout.write(input.getBytes());
			//.write(바이트배열)
		//문자열.getBytes() : 해당 문자열을 바이트 배열 변환 => 인풋(스캐너받은문자)를 바이트화 시켜줌
		}
		
		
		
		
		
	}
}
