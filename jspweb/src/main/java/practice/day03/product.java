package practice.day03;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/product")
public class product extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public product() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<productDto>result=productDao.getInstance().출력();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(result);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product=request.getParameter("product");
		String price=request.getParameter("price");
		
		productDto dto=new productDto(0, product, price);
		
		boolean result=productDao.getInstance().등록(dto);
		
		response.getWriter().print(result);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno=Integer.parseInt(request.getParameter("pno"));
		String newprice=request.getParameter("newprice");
		String newpproduct=request.getParameter("newpproduct");
		boolean result=productDao.getInstance().pupdate(pno, newpproduct, newprice);
		response.getWriter().print(result);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno=Integer.parseInt(request.getParameter("pno"));
		boolean result=productDao.getInstance().pdelete(pno);
		
		response.getWriter().print(result);
		
	}

}
