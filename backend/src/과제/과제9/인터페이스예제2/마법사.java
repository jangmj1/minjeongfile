package 과제.과제9.인터페이스예제2;

public class 마법사 implements 캐릭터{

	@Override
	public void 생성(String id,String pw) {
		System.out.println(id+"님 마법사를 선택 하셨습니다.");
		System.out.println("공격은 A key , 마나포션 B key ");
		System.out.println("즐거운게임 하세요");
		
	}

	@Override
	public void 공격(String key) {
		if(key.equals("A")) {
			System.out.println("슉! 얍! 슉!! 얍!!");
		}
	}

	@Override
	public void 방어(String key) {
		if(key.equals("B")) {
			System.out.println("꿀꺽꿀꺽");
		}
		
	}

}
