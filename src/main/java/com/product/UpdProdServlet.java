package com.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.product;
import com.product.ProductDBUtil;

@WebServlet("/UpdProdServlet")
public class UpdProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		String pdesc=request.getParameter("pdesc");
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		String category=request.getParameter("categories");
		String username=request.getParameter("username");
		
		boolean isTrue;
		
		isTrue = ProductDBUtil.updateproduct(pid, pname, pdesc, pprice, category);
		
		if (isTrue == true) {
			
			List<product> prodDetails = ProductDBUtil.getprodDetails(pid);
			request.setAttribute("prodDetails", prodDetails);
			RequestDispatcher dis = request.getRequestDispatcher("ViewProduct.jsp?username=<%out.print(username);%>");
			dis.forward(request, response);
		}
		else {
			List<product> prodDetails = ProductDBUtil.getprodDetails(pid);
			request.setAttribute("prodDetails", prodDetails);
			RequestDispatcher dis = request.getRequestDispatcher("ViewProduct.jsp");
			dis.forward(request, response);
			System.out.println("Data update failed");
		}
	}

}
