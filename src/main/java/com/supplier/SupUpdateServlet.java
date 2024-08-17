package com.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupUpdateServlet")
public class SupUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("supid");
		String name = request.getParameter("name");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.updatesupplier(id, name, email, phone, username, password);
		
		if(isTrue == true) {
			List<Supplier> supDetails = SupplierDBUtil.getSupplier(username);
			request.setAttribute("supDetails", supDetails);
			request.setAttribute("username", username);
			RequestDispatcher dis = request.getRequestDispatcher("SupProfile.jsp");
			dis.forward(request, response);
		} else {
			List<Supplier> supDetails = SupplierDBUtil.getSupplier(username);
			request.setAttribute("supDetails", supDetails);
			request.setAttribute("username", username);
			RequestDispatcher dis2 = request.getRequestDispatcher("SupProfile.jsp");
			dis2.forward(request, response);
		}
	}

}
