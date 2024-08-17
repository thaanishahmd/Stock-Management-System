package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductDBUtil;

import cus.register.Customer;
import cus.register.CustomerDBUtil;

@WebServlet("/AddProdServlet")
public class AddProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String pname = request.getParameter("p_name");
		String pdesc = request.getParameter("p_desc");
		int pprice = Integer.parseInt(request.getParameter("p_price"));
		String cat = request.getParameter("categories");
		String username=request.getParameter("username");
		
		boolean isTrue;
		
		isTrue = ProductDBUtil.addproduct(pname, pdesc, pprice, cat);
		
		if(isTrue == true) {
			List<product> prodDetails = ProductDBUtil.getproduct(pname);
			request.setAttribute("prodDetails", prodDetails);
			RequestDispatcher dis = request.getRequestDispatcher("ViewProduct.jsp?username=<%out.print(username);%>");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Cannot add product');");
			out.println("location='ViewProduct.jsp?username=<%out.print(username);%>'");
			out.println("</script>");
		}
	}

}
