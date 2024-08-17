package cus.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CusUpdateServelet")
public class CusUpdateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("cusid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String username=request.getParameter("un");
		String password=request.getParameter("psw");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updatecustomer(id, name, email, phone, username, password);
		
		if (isTrue == true) {
			
			List<Customer> cusDet = CustomerDBUtil.getCustomer(username);
			request.setAttribute("username", username);
			request.setAttribute("CusDetails", cusDet);
			RequestDispatcher dis = request.getRequestDispatcher("CusProfile.jsp");
			dis.forward(request, response);
		}
		else {
			List<Customer> cusDet = CustomerDBUtil.getCustomer(username);
			request.setAttribute("username", username);
			request.setAttribute("CusDetails", cusDet);
			RequestDispatcher dis = request.getRequestDispatcher("CusProfile.jsp");
			dis.forward(request, response);
			System.out.println("Data update failed");
		}
	}
}
