package com.supplier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupRegisterServlet")
public class SupRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.insertsupplier(name, username, password, email, phone);
		
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Successfully Registered');");
			out.println("location='suplogin.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Registering Unsuccessful');");
			out.println("location='SupRegister.jsp'");
			out.println("</script>");
		}
	}

}
