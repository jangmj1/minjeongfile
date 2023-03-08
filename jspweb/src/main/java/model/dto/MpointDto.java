package model.dto;

public class MpointDto {
	private int mpno;
	private String mpcomment;
	private int mpoint;
	private String mdate;
	private int mno ;
	
	public MpointDto() {
		// TODO Auto-generated constructor stub
	}

	public MpointDto(int mpno, String mpcomment, int mpoint, String mdate, int mno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpoint = mpoint;
		this.mdate = mdate;
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mpcomment=" + mpcomment + ", mpoint=" + mpoint + ", mdate=" + mdate
				+ ", mno=" + mno + "]";
	}

	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
	
}
