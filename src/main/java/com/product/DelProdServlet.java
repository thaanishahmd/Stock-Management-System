package com.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cus.register.Customer;
import com.product.*;


@WebServlet("/DelProdServlet")
public class DelProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String username=request.getParameter("username");
		
		boolean isTrue = ProductDBUtil.deleteproduct(pid);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ViewProduct.jsp?username=<%out.print(username);%>");
			dis.forward(request, response);
		}
		else {
			List<product> prodDetails = ProductDBUtil.getprodDetails(pid);
			request.setAttribute("prodDetails", prodDetails);
			RequestDispatcher dis = request.getRequestDispatcher("ProdDetails.jsp");
			dis.forward(request, response);
			System.out.println("Account Delete failed");
		}
	}

}
