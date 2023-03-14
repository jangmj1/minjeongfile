package practice.과제1;

public class MemberDto {

	private int no;
	private String mimg;
	private String name;
	private String mrank;
	private String employment;
	private String division;
	private String idate;
	private String edate;
	private String resign;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int no, String mimg, String name, String mrank, String employment, String division, String idate,
			String edate, String resign) {
		super();
		this.no = no;
		this.mimg = mimg;
		this.name = name;
		this.mrank = mrank;
		this.employment = employment;
		this.division = division;
		this.idate = idate;
		this.edate = edate;
		this.resign = resign;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMrank() {
		return mrank;
	}

	public void setMrank(String mrank) {
		this.mrank = mrank;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getResign() {
		return resign;
	}

	public void setResign(String resign) {
		this.resign = resign;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", mimg=" + mimg + ", name=" + name + ", mrank=" + mrank + ", employment="
				+ employment + ", division=" + division + ", idate=" + idate + ", edate=" + edate + ", resign=" + resign
				+ "]";
	}
	
	
}
