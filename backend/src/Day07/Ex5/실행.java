package Day07.Ex5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class 실행 {//c s
	public static void main(String[] args) {// m s
		
		//객체 3개만들기
		Member m1=new Member();
		m1.id="ggg"; m1.password="111";
		
		Member m2=new Member();
		m2.id="sss"; m2.password="222";
		
		Member m3=new Member();
		m3.id="eee"; m3.password="333";
		
		//1.배열[언어문법] 고정길이
		Member[] memberList1=new Member[3];
		memberList1[0] = m1;
		memberList1[1] = m2;
		memberList1[2] = m3;
		
		//1.1 삭제
		System.out.println(Arrays.toString(memberList1));
		memberList1[1]=null;
		System.out.println(Arrays.toString(memberList1));
		
		//2. 컬렉션[수집] 프레임워크 [미리 만들어진 클래스] 가변길이
		ArrayList<Member> memberList2=new ArrayList<>();
		memberList2.add(m1);
		memberList2.add(m2);
		memberList2.add(m3);
		
		//2.1 삭제
		System.out.println(memberList2);
		memberList2.remove(1); //'1'인덱스를 넣어라
		System.out.println(memberList2);
		
		
		
	}// m e

}// c e
