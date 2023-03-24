package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.productDao;
import model.dto.productDto;

@WebServlet("/product/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public info() {
        super();
    }
    ObjectMapper mapper=new ObjectMapper();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double 동= Double.parseDouble(request.getParameter("동")) ;	System.out.println(동);
		double 서= Double.parseDouble(request.getParameter("서")) ;	System.out.println(서);
		double 남= Double.parseDouble(request.getParameter("남")) ;	System.out.println(남);
		double 북= Double.parseDouble(request.getParameter("북")) ;	System.out.println(북);
    	
		ArrayList<productDto> result=productDao.getInstance().getproductList(동,서,남,북);
		
		String jsonarray=mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getSession().getServletContext().getRealPath("/product/pimg");
		
		MultipartRequest multi=new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String pname=multi.getParameter("pname");					System.out.println(pname);
		String pcomment=multi.getParameter("pcomment");				System.out.println(pcomment);
		int pprice=Integer.parseInt(multi.getParameter("pprice")) ;	System.out.println(pprice);
		String plat=multi.getParameter("plat");						System.out.println(plat);
		String plng=multi.getParameter("plng");						System.out.println(plng);
		
		productDto dto=new productDto(pname, pcomment, pprice, plat, plng);
		boolean result=productDao.getInstance().write(dto);
		response.getWriter().print(result);
	
	}
	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
