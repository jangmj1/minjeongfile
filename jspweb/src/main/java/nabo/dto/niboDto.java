package nabo.dto;

public class niboDto {
	int myno ;
	String today ;
	double height ;
	double weight ;
	double bmi ;
	int eno ;

	//추가
	String sports;

	public niboDto() {
		// TODO Auto-generated constructor stub
	}


	//풀생성자-추가 sports 안해도 상관없나?
	public niboDto(int myno, String today, double height, double weight, double bmi, int eno) {
		super();
		this.myno = myno;
		this.today = today;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.eno = eno;
	}



	
	//출력용 type 1
	public niboDto(int myno, String today, double weight) {
		super();
		this.myno = myno;
		this.today = today;
		this.weight = weight;
	}


	//출력용 type 2
	public niboDto(double height, double weight, double bmi, String sports) {
		super();
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.sports = sports;
	}


	public int getMyno() {
		return myno;
	}


	public void setMyno(int myno) {
		this.myno = myno;
	}


	public String getToday() {
		return today;
	}


	public void setToday(String today) {
		this.today = today;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getBmi() {
		return bmi;
	}


	public void setBmi(double bmi) {
		this.bmi = bmi;
	}


	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getSports() {
		return sports;
	}


	public void setSports(String sports) {
		this.sports = sports;
	}



}
