package Day15.Ex2;

public class Student {
	private int no;
	private String name;
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int hashCode=no+name.hashCode();
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student target=(Student)obj;//Object obj 를 -> (Student) 자료형으로 강제형변환
			if(no==target.getNo()
					&& name.equals(target.getName() )) {
				return true;
			}
		}
		return false;
	}
}
