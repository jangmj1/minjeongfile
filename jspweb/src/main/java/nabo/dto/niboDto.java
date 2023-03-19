package nabo.dto;

public class niboDto {
	
	String today ;
	double height ;
	double weight ;
	double bmi ;
	int eno ;

	
	public niboDto() {
		// TODO Auto-generated constructor stub
	}


	public niboDto(String today, double height, double weight, double bmi, int eno) {
		super();
		this.today = today;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.eno = eno;
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
	
	
}
