package 과제.과제4싱글톤;

import 과제.과제4싱글톤.view.Front;

public class Start {
	
	public static void main(String[] args) {
		
		Front.getInstance().index();
		/*
		 * Front.front.index(); Front front = new Front();
		 */
		
	}
}

/*
 * 	M : 데이터 모델링[저장하고자 하는 데이터들의 설계]
 * 	V : 입.출력 그냥 프론트
 * 	C : 제어 /비지니스 로직이 (기능처리)
 * 
 * 	예)회원가입으로 예시
 * 		V: ID or PW 만 받는거==>HTML역활
 * 		C: 입력받은 데이터를 유효성 검사를 하고 저장 V와M 사이에서 중간역활==>JAVA
 * 		M: 컨트롤이 데이터를 저장할때 사용되는 모델링/설계==>DB역활
 * 
 * 		V에서 사실 모든걸 처리할수있지만 코드구별하기어렵고 관리가 어렵다 
 */

