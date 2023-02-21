package Day15.Ex1;

public class Member {
	
	public String id;

	public Member(String id) {
		this.id = id;
		
		
	}
	
	@Override
	//객체 내부를 비교하기위해
	public boolean equals(Object obj) {
		
			//부모객체 instanceof 자식클래스 변환 객체명
			//obj -> target
		if(obj instanceof Member) { 
			Member target=(Member)obj; //if(obj instanceof Member target) { } 이거랑 동일함
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}

}
