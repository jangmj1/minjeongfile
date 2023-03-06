package practice.day03;

public class productDto {

		private int pno;
		private String pproduct;
		private String pprice;
	
	
		public productDto() {
			// TODO Auto-generated constructor stub
		}


		public productDto(int pno, String pproduct, String pprice) {
			super();
			this.pno = pno;
			this.pproduct = pproduct;
			this.pprice = pprice;
		}


		public int getPno() {
			return pno;
		}


		public void setPno(int pno) {
			this.pno = pno;
		}


		public String getPproduct() {
			return pproduct;
		}


		public void setPproduct(String pproduct) {
			this.pproduct = pproduct;
		}


		public String getPprice() {
			return pprice;
		}


		public void setPprice(String pprice) {
			this.pprice = pprice;
		}
		
		
		
	
	
}
