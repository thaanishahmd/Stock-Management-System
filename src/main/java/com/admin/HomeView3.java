package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeView3")
public class HomeView3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		
		List<Admin> admin = AdminDBUtil.getAdmin(username);
		request.setAttribute("adminDetails", admin);
		request.setAttribute("username", username);
		RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
		dis.forward(request, response);
	}

}
