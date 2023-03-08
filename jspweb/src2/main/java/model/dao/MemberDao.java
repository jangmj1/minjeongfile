package model.dao;

public class MemberDao extends Dao{
	
	private static MemberDao dao=new MemberDao();
	
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDao getInstance() {
		return dao;
	}


	

}
