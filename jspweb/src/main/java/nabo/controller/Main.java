package nabo.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import nabo.dao.niboDao;
import nabo.dto.niboDto;
@WebServlet("/nicebody")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Main() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int type=Integer.parseInt(request.getParameter("type"));
		System.out.println("타입"+type);
		int myno=0;
		ArrayList<niboDto>result=null;//전역변수
		if(type==1) {
			
		}else if (type==2) {
			myno=Integer.parseInt(request.getParameter("myno"));
			
		}
		result=niboDao.getInstance().print(type,myno);
		System.out.println(result);
		ObjectMapper mapper=new ObjectMapper();
		String jsonArray=mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		String today=request.getParameter("today");	/*입력한시간*/					System.out.println("today"+today);
		String testheight= request.getParameter("height");				System.out.println("testheight"+testheight);
		String testweight= request.getParameter("weight");				System.out.println("testweight"+testweight);
		
		if("".equals(today)||"".equals(testweight)||"".equals(testweight)) {//만약에 빈칸이 있을경우
			response.getWriter().print(false); //펄스를 보내주고 
			return;//끝내버림
		}
		
		LocalDate now=LocalDate.now();/*현재시간*/		System.out.println("현재 :"+now);
		
		LocalDate testdate=LocalDate.parse(today);	/*입력한시간=>local자료형 변환*/	System.out.println("입력한 날짜"+testdate);
		
		if(testdate.isBefore(now)){ //현재시간보다 입력값이 과거면 -> 현재시간과 선택시간을 비교
			
				System.out.println("선택값이 과거다[x]");
				response.getWriter().print(1); //1을반환시키고
				return;//끝내버린다
			}
		
		
		  double height=Double.parseDouble(testheight) ;System.out.println(height);
		  double weight=Double.parseDouble(testweight) ;System.out.println(weight);
		  int exercise=Integer.parseInt(request.getParameter("exercise")) ;System.out.println(exercise);
		  double testbmi=(weight/(height*height))*10000;
		  double bmi=Math.round(testbmi*100)/100.0; System.out.println(bmi); //비만율 계산
		  
		  
		  niboDto dto=new niboDto(0, today, height, weight, bmi, exercise);
		  
		  boolean result=niboDao.getInstance().bodycheck(dto);
		  response.setCharacterEncoding("UTF-8");
		  
		  
		  response.getWriter().print(result);
		 
		
		
	
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//수정하기
		System.out.println("수정하기풋방식 연동");
		String upheight1=request.getParameter("upheight");System.out.println("upheight1"+upheight1);//널로 들어오네..? 왜??
		double upheight= Double.parseDouble(request.getParameter("upheight")); System.out.println(upheight);
		double upweight= Double.parseDouble(request.getParameter("upweight")); System.out.println(upweight);
		int upeno=Integer.parseInt(request.getParameter("upeno")); System.out.println(upeno);
		int myno=Integer.parseInt(request.getParameter("myno")); System.out.println(myno);
		double testbmi=(upweight/(upheight*upheight))*10000;//비만율 계산
		double bmi=Math.round(testbmi*100)/100.0; System.out.println(bmi); //비만율 소수점 두번쨰자리
		
		boolean result=niboDao.getInstance().update(upheight, upweight, bmi, upeno, myno);
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().print(result);
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
