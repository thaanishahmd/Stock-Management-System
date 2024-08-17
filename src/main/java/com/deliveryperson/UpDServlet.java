package com.deliveryperson;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpDServlet")
public class UpDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("dp_id");
		String name = request.getParameter("name");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.updatedeliveryperson(id, name, email, phone, username, password);
		
		if(isTrue == true) {
			List<DeliveryPerson> dpDetails = DeliveryDBUtil.getDeliveryPerson(username);
			request.setAttribute("dpDetails", dpDetails);
			request.setAttribute("username", username);
			RequestDispatcher dis = request.getRequestDispatcher("DpProfile.jsp");
			dis.forward(request, response);
		} else {
			List<DeliveryPerson> dpDetails = DeliveryDBUtil.getDeliveryPerson(username);
			request.setAttribute("dpDetails", dpDetails);
			request.setAttribute("username", username);
			RequestDispatcher dis2 = request.getRequestDispatcher("DpProfile.jsp");
			dis2.forward(request, response);
		}
	}

}
