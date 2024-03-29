package model.dto;

public class ChatDto {
	
	private long nno;
	private String ncontent;
	private String ndata;
	private int pno;
	private int frommno;
	private int tomno;
	
	public ChatDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatDto(long nno, String ncontent, String ndata, int pno, int frommno, int tomno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndata = ndata;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}

	public long getNno() {
		return nno;
	}

	public void setNno(long nno) {
		this.nno = nno;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdata() {
		return ndata;
	}

	public void setNdata(String ndata) {
		this.ndata = ndata;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getFrommno() {
		return frommno;
	}

	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}

	public int getTomno() {
		return tomno;
	}

	public void setTomno(int tomno) {
		this.tomno = tomno;
	}

	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndata=" + ndata + ", pno=" + pno + ", frommno="
				+ frommno + ", tomno=" + tomno + "]";
	}
	
	

}
