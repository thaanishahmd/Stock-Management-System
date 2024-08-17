package com.deliveryperson;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DelDServlet ")
public class DelDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("dp_id");
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.deletedeliveryperson(id);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("DpRegister.jsp");
			dispatcher.forward(request, response);
		}
		else {
		
			List<DeliveryPerson> dpDetails = DeliveryDBUtil.getDeliveryPersonDetails(id);
			request.setAttribute("dpDetails", dpDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("DpProfile.jsp");
			dispatcher.forward(request, response);
		}
	}

}
