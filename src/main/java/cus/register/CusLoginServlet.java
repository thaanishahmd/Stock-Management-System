package cus.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cus.register.Customer;
import cus.register.CustomerDBUtil;

@WebServlet("/CusLoginServlet")
public class CusLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("user"); 
		String password = request.getParameter("psw");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.validate(username, password);
		
		if(isTrue == true) {
			HttpSession session=request.getSession();
			session.setAttribute("cususer", username);
			List<Customer> cusDet = CustomerDBUtil.getCustomer(username);
			request.setAttribute("username", username);
			request.setAttribute("CusDetails", cusDet);
			RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
			dis.forward(request, response);
		}
		else{
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='cuslogin.jsp'");
			out.println("</script>");
		}
		
		
	}

}
