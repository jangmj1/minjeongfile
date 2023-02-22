package 과제.과제11;

import java.util.ArrayList;

import Day15.Ex9_MVC.MemberDao;
import Day15.Ex9_MVC.MemberDto;

public class Controller {
	
	private static Controller controller=new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return controller;
	}
	

	public boolean newProduct(String pname,int price,int pinven) {
		
		ProductDto dto=new ProductDto(0, pname, price, pinven);
		
		
			boolean result=ProductDao.getInstance().newProduct(dto);
			
			return result;
	}
	
	
	
	public ArrayList<ProductDto> list() {
		
		ArrayList<ProductDto> result=ProductDao.getInstance().list();
		
		return result;
	}
	
	
	public boolean Update(int pno,String pname,int pprice) {
		
		boolean result=ProductDao.getInstance().Update(pno, pname, pprice);
		
		return result;
	}
	
	public boolean UpdateInven(int pno,int pinven) {
		
		return 	ProductDao.getInstance().UpdateInven(pno, pinven);
	}
	
	public boolean del(int pno) {
		
		boolean result=
		ProductDao.getInstance().del(pno);
		
		return result;
	}
	
	public ArrayList<ProductDto> cart(int ch){
		return ProductDao.getInstance().cart(ch);
	}
	
	
}


	