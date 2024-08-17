package com.deliveryperson;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DpView")
public class DpView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getParameter("username");
		List<DeliveryPerson> dpDetails = DeliveryDBUtil.getDeliveryPerson(username);
		request.setAttribute("username", username);
		request.setAttribute("dpDetails", dpDetails);
		RequestDispatcher dis = request.getRequestDispatcher("DpProfile.jsp");
		dis.forward(request, response);
	}

}
