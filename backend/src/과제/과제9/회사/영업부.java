package 과제.과제9.회사;

public class 영업부 implements 출결{
	
	String name;

	@Override
	public void 출근() {
		System.out.println("출근자 이름:");
		this.name=scanner.next();
		System.out.println("영업부"+name+"님이 출근 하였습니다.");
		
	}

	@Override
	public void 퇴근() {
		System.out.println("퇴근자 이름:");
		this.name=scanner.next();
		System.out.println("영업부"+name+"님이 퇴근 하였습니다.");
		
	}
	

	
}
