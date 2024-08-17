package cus.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supplier.Supplier;
import com.supplier.SupplierDBUtil;

/**
 * Servlet implementation class CustomerView
 */
@WebServlet("/CustomerView")
public class CustomerView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getParameter("username");
		List<Customer> cusDet = CustomerDBUtil.getCustomer(username);
		request.setAttribute("username", username);
		request.setAttribute("CusDetails", cusDet);
		RequestDispatcher dis = request.getRequestDispatcher("CusProfile.jsp");
		dis.forward(request, response);
	}

}
