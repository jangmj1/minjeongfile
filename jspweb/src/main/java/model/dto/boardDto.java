package model.dto;

public class boardDto {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private int bview;
	private int bup;
	private int bdown;
	private int mno;
	private int cno;
	//추가필드
	private String mid;
	
	
	public boardDto() { // 1.기본 깡통
		// TODO Auto-generated constructor stub
	}


	public boardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno) { // 2.기본 풀
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
	}


	public boardDto(String btitle, String bcontent, String bfile, int mno, int cno) { //3.게시글 쓸때 필요한거
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}


	public boardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid=mid;
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


	public String getBfile() {
		return bfile;
	}


	public void setBfile(String bfile) {
		this.bfile = bfile;
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


	public int getBup() {
		return bup;
	}


	public void setBup(int bup) {
		this.bup = bup;
	}


	public int getBdown() {
		return bdown;
	}


	public void setBdown(int bdown) {
		this.bdown = bdown;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}

	
 


	
	
}
