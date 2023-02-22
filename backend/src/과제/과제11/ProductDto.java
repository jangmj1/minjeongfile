package 과제.과제11;

public class ProductDto {
	//1. 필드
	private int pno;
	private String pname;
	private int pprice;
	private int pinven;

	
	//생성자
	
	public ProductDto() {
	}


	public ProductDto(int pno, String pname, int pprice, int pinven) {
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pinven = pinven;
	}

	//메소드 (게터세터)
	
	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public int getPinven() {
		return pinven;
	}


	public void setPinven(int pinven) {
		this.pinven = pinven;
	}


	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pinven=" + pinven + "]";
	}
	
	

	
	
	
}

