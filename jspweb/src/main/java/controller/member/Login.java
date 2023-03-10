package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.세션에 담겨진 회원 아이디를 호출하기
		String mid=(String)request.getSession().getAttribute("login");
		
		//2.로그인한 회원의 정보 호출 비번 빼고
		MemberDto result= MemberDao.getInstance().getMember(mid);
		
			//java객체 -->js객체로 변환
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(result); //리설트가 json되고 json을 보내준다
		
		//3.응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.js 의 ajax 한테 값을 요청(request)
		String mid= request.getParameter("mid");
		String mpwd= request.getParameter("mpwd");
		
		//2.dao 호출해서 요청데이터를 보내서 결과 얻기
		boolean result=MemberDao.getInstance().login(mid,mpwd);
			
		if(result==true) { //로그세션만들기
			
			//request.getSession() : 서버[톰캣] 내 세션 객체 호출
			//setAttribute("key", value); :서버[톰캣] 내 세션객체에 속성[데이터]추가(저장) 반대는 getAttribute
			
			//세션내에 login 이라는 이름으로 로그인 성공한 데이터 저장  (오브젝트 자료형이라 모든걸 다넣을수있다)
			request.getSession().setAttribute("login", mid);
		}
		
		//3.dao에게 받은 result값을 다시 ajax 전달
		response.getWriter().print(result);
	
	}


}
