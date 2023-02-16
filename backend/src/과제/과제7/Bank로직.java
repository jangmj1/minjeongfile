package 과제.과제7;

public class Bank로직 {
//	ArrayList<bank>bankDb= new ArrayList<>();// 한페이지에서 왜안만들어지는걸까

	public void join() {
		 Bank bank=(Bank)this;
		
		 
		if(bank.name==null||bank.pw==null) {
			System.out.println("빈칸을 채워주세요");
			return;
		
		}else{
			실행.get실행().BankDb.add(bank);
			
		}
		
	
		
		
		
		
	}

}
