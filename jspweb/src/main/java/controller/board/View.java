package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.boardDao;

@WebServlet("/board/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 타입과 게시물 번호 요청
		int type=Integer.parseInt(request.getParameter("type")); System.out.println(type);
		int bno=Integer.parseInt(request.getParameter("bno"));System.out.println(bno);
		
		/*
		 	새로고침 할떄마다 조회수가 증가하는걸 막기
		 	-하루에 한번씩 조회수 또는 좋아요 싫어요수 증가 가능
		 	-회원별 vs pc마다 할꺼냐 => pc마다하자!(pc의 식별자가 필요하다 ip 필요)
		 	-세션 샤용
		 	
		 	1.pc마다하자!(pc의 식별자가 필요하다 ip 필요)
		 		1.java에서 현재 요청한 클라이언트의 ip 확인
		 */
		String ip=request.getRemoteAddr();
			System.out.println("ip:"+ip);
			
			//4.만약에 기존 세션이 없으면 증가가능 없으면 증가 불가(2번세션이 한번도 만들어진적이 없으면 즉 첫방문이면  o=null )
								
			Object o=request.getSession().getAttribute(type+ip+bno);
				if(o==null) {
					//2.세션 생성[ip+type+bno] : 게시물 마다, 타입마다(좋아요 싫어요 조회수) , pc마다
					request.getSession().setAttribute(type+ip+bno,1);
					
					//3.세션 허용 시간 [생명주기]가 지나면 자동으로 메모리 삭제 /초 단위
						//1.서버를 끄거나(consol창),2.setMaxInactiveInterval 를 넣거나
					request.getSession().setMaxInactiveInterval(60*60*24);//60*60*24 초단위 하루
					
					
					//dao처리
					boardDao.getInstance().bincrease(type,bno);
				}
			
			
			
		
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
