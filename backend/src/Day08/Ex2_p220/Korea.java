package Day08.Ex2_p220;

public class Korea {
	//필드
		String nation="대한민국";
		String name;
		String ssn;
		
	//생성자
		public Korea() {
		}//빈 생성자
		
		public Korea( String name,String ssn) {
			this.name=name;
			this.ssn=ssn;
			
			}

	//메소드
		@Override
		public String toString() {
			return "Korea [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
		}
		
}
