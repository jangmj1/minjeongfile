package 과제.과제3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class 실행 { // cs
	public static void main(String[] args) {// ms
		
		
		Scanner scanner=new Scanner(System.in);
		
		ArrayList<Book> bookList=new ArrayList<>();//가변길이 생성됨
		ArrayList<Member> memberList=new ArrayList<>();
		
	 start:	while(true) {//w s
			System.out.println("1.로그인 2.회원가입");
			int ch1= scanner.nextInt();
			if(ch1==1) {//로그인 if 시작
				System.out.println("아이디:"); String id=scanner.next();
				System.out.println("비밀번호:"); String pw=scanner.next();							
				
				//성공시 밑에 와일문 넣기
				for(int j=0;j<memberList.size();j++) {//for s
					System.out.println("작동");
				
					System.out.println(memberList.size());
							
					if(id.equals(memberList.get(j).id)&&pw.equals(memberList.get(j).pw)) {//ifs
						System.out.println("******로그인성공!******");
						
						while (true) {//ws 로그인 성공시 와일문 시작
							
							System.out.println("번호\t대여여부\t도서장르\t도서명");
							/*출력*/
								String state;
							for(int i=0;i<bookList.size();i++) {
								if(bookList.get(i).state==true) {
									state="가능";
								}else {
									state="불가능";
								}
								System.out.println(
										i+"\t"+state+"\t"+bookList.get(i).장르
										+"\t"+bookList.get(i).도서명);
							}
							
							
							System.out.println("1.도서대여 2.도서반납 3.도서등록[관리자]");
							int ch=scanner.nextInt();
							
							
							
							if(ch==1) {
								System.out.println("-----대여페이지-----");
								System.out.println("대여번호를 선택하여 주세요");
								int no=scanner.nextInt();
								
								
								if(bookList.get(no).state==true) {
									System.out.println("대여 성공");
									bookList.get(no).state=false;
									
									
									 String memberName=memberList.get(j).id;
									 System.out.println("대여해간회원의 id:"+memberName);
									 
									
									
								}else if (bookList.get(no).state==false) {
									System.err.println("대여불가능");
								}else {
									System.err.println("번호를 확인하여주세요");
								}
								
							
								
								
							}else if (ch==2) {
								System.out.println("-----반납페이지-----");
								System.out.println("반납할 번호를 선택해주세요");
								int no=scanner.nextInt();
								if(bookList.get(no).state==false) {
									System.out.println("반납성공");
									bookList.get(no).state=true;
									
								}else if (bookList.get(no).state==true) {
									System.err.println("반납실패");
								}else {
									System.err.println("번호를 확인하여주세요");
								}
								
							}else if (ch==3) {
								System.out.println("-----등록페이지-----");
								
								
								System.out.println("도서명:"); String 도서명=scanner.next();
								System.out.println("장르:");	String 장르=scanner.next();
															Boolean basicstate=true;
								//스트링과 불리언..다양한 자료형을 book으로 묶어서 한개의 객체로 만듬
															
								Book book=new Book();
								
								book.도서명=도서명;
								book.장르=장르;
								book.state=basicstate;
								bookList.add(book); //한개의 객체를 북 리스트에 추가
						
							}else {System.err.println("잘못눌렀습니다.");	}
						
							
							}//we	
						
					
					//if e	
					}else if(id.equals(memberList.get(j).id) && !pw.equals(memberList.get(j).pw)) {
						System.err.println("비밀번호가틀렸습니다.");
						continue start;
					}else if(!id.equals(memberList.get(j).id)  && pw.equals(memberList.get(j).pw)) {
						System.err.println("아이디가 틀렸습니다.");
						continue start;
					}
					
					
				}//for e				
				//만약에 반복문을 다 돌았을시
				if(memberList.indexOf(id) < 0 && memberList.indexOf(pw) < 0) {
					System.err.println("회원이 존재하지않습니다.");
					continue start;
				}
			}//로그인 if 끝
			else if (ch1==2) {//else if s 회원가입
				System.out.println("아이디:"); String inputId=scanner.next();
				System.out.println("비밀번호:");String inputPw=scanner.next();
				System.out.println("이름:");String inputName=scanner.next();
				System.out.println("phone:");String inputPhone=scanner.next();
				
				Member member=new Member();
				member.id=inputId;
				member.pw=inputPw;
				member.name=inputName;
				member.phone=inputPhone;
				memberList.add(member);				
				System.out.println("회원가입완료! 다시 로그인해주세요!");
				
				
			}// else if e
			
			
			
			
		
		
		
		}//w e
		
	}//me

}//ce
