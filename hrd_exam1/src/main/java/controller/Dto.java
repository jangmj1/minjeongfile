package controller;

public class Dto {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private int city;
	private String psum;
	
	public Dto() {
		// TODO Auto-generated constructor stub
	}

	public Dto(int custno, String custname, String phone, String address, String joindate, String grade, int city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public Dto(int custno, String custname, String grade, String psum) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.psum = psum;
	}

	public String getPsum() {
		return psum;
	}

	public void setPsum(String psum) {
		this.psum = psum;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}
	

}
