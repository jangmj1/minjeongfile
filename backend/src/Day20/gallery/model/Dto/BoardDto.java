package Day20.gallery.model.Dto;

public class BoardDto {

	private int bno;
	private String btitle;
	private String bcontent ;
	private String bdate ;
	private int bview;
	private String mdi; //fk
	private String cname; //fk
	
	
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}



	public BoardDto(int bno, String btitle, String bcontent, String bdate, int bview, String mdi, String cname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.mdi = mdi;
		this.cname = cname;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getBtitle() {
		return btitle;
	}



	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}



	public String getBcontent() {
		return bcontent;
	}



	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}



	public String getBdate() {
		return bdate;
	}



	public void setBdate(String bdate) {
		this.bdate = bdate;
	}



	public int getBview() {
		return bview;
	}



	public void setBview(int bview) {
		this.bview = bview;
	}



	public String getMdi() {
		return mdi;
	}



	public void setMdi(String mdi) {
		this.mdi = mdi;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
}
