package com.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cus.register.Customer;
import cus.register.CustomerDBUtil;

/**
 * Servlet implementation class SupplierView
 */
@WebServlet("/SupplierView")
public class SupplierView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getParameter("username");
		List<Supplier> supDetails = SupplierDBUtil.getSupplier(username);
		request.setAttribute("username", username);
		request.setAttribute("supDetails", supDetails);
		RequestDispatcher dis = request.getRequestDispatcher("SupProfile.jsp");
		dis.forward(request, response);
	}

}
