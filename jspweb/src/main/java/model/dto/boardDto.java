package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String mid;//작성자 아이디
	private String mimg;//작성자 프로필이미지
	private int rcount;//댓글개수
	
	
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

	//등록용
	public boardDto(String btitle, String bcontent, String bfile, int mno, int cno) { //3.게시글 쓸때 필요한거
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}

	//출력용
	public boardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		
		//오늘 날짜와 작성일이 동일하면 시간 표기/아니면 날짜 표기
			//1.오늘날짜
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now=sdf.format(date);//현재날짜
		
			//2.만약에 오늘날짜와 작성일과 동일하면[split=>문자열 자르기 함수]
				//now.split(" ")[0]=>yyyy-MM-dd 	now.split(" ")[1]=>hh:mm:ss
		if(now.split(" ")[0].equals(bdate.split(" ")[0]) ){//같은 날짜면
			this.bdate = bdate.split(" ")[1];//시간만 
		}else {
			this.bdate = bdate.split(" ")[0];//날짜만
			
		}
		
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid=mid;
	}
	
	//업데이트용
	
	public String getMimg() {
		return mimg;
	}




	public void setMimg(String mimg) {
		this.mimg = mimg;
	}




	public int getRcount() {
		return rcount;
	}




	public void setRcount(int rcount) {
		this.rcount = rcount;
	}




	public boardDto(int bno, String btitle, String bcontent, String bfile, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno = cno;
	}
	
	

	
	@Override
	public String toString() {
		return "boardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", bup=" + bup + ", bdown=" + bdown + ", mno=" + mno
				+ ", cno=" + cno + ", mid=" + mid + "]";
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
