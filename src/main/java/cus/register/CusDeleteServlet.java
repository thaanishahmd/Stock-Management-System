package cus.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CusDeleteServlet")
public class CusDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("cusid");
		String username=request.getParameter("username");
		
		boolean isTrue = CustomerDBUtil.deletecustomer(id);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("CusRegister.jsp");
			dis.forward(request, response);
		}
		else {
			List<Customer> cusDetails = CustomerDBUtil.getCusDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			RequestDispatcher dis = request.getRequestDispatcher("CusProfile.jsp");
			dis.forward(request, response);
			System.out.println("Account Delete failed");
		}
	}

}
