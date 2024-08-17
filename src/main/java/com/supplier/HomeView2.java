package com.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeView2")
public class HomeView2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		
		List<Supplier> supDetails = SupplierDBUtil.getSupplier(username);
		request.setAttribute("supDetails", supDetails);
		request.setAttribute("username", username);
		RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
		dis.forward(request, response);
	}

}
