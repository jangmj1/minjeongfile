package 과제.과제4;

import 과제.과제4.view.Front;

/*
 	MVD:디자인 패턴[관점별 파일 구분]
 		M : model		데이터		db
 		V : view		화면			html,css,js
 		C :	controller	제어[로직]		java
 
 
 
 
 */

public class Start {

	public static void main(String[] args) {
		
		Front front =new Front();
		
				front.index();
		
	}
}
