package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.boardDao;
import model.dto.replyDto;
@WebServlet("/board/reply")
public class reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.bno가져오기
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		int type=Integer.parseInt(request.getParameter("type"));
		
		int rindex=0;
		if(type==1) {//상위댓글 출력 int rindex=0;
			
		}else if (type==2) {//하위댓글 출력
			 rindex=Integer.parseInt(request.getParameter("rindex"));
			
		}
		//2.dao 
		ArrayList<replyDto> result= boardDao.getInstance().getReplyList(bno,rindex);
		
		//3.
		ObjectMapper mapper=new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno=Integer.parseInt(request.getParameter("bno"));
		int mno=MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login")) ;
		String rcontent=request.getParameter("rcontent");
		int type=Integer.parseInt(request.getParameter("type"));
		
		replyDto dto=new replyDto(rcontent, mno, bno);
		if(type==1) { //상위 대글 다 밖으로 빼놔서 딱히 할게없음
		}else if (type==2) {//하위댓글
			int rindex=Integer.parseInt(request.getParameter("rindex"));
			dto.setRindex(rindex);
		}
		
		System.out.println("dto"+dto);
		boolean result=boardDao.getInstance().rwrite(dto);
		response.getWriter().print(result);
	
	}

}
