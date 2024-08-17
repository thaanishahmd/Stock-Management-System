package OrderSup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cus.register.CustomerDBUtil;


@WebServlet("/AddOrderSupServlet")
public class AddOrderSupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String pname = request.getParameter("prodname");
		int pquantity = Integer.parseInt(request.getParameter("p_quantity"));
		String supname = request.getParameter("supname");
		String username=request.getParameter("username");
		
		boolean isTrue;
		
		isTrue = OrderSupDBUtil.insertordersup(pname, pquantity, supname);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("OrderSupView.jsp?username=<%out.print(username);%>");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Order Unsuccessful');");
			out.println("location='OrderSup.jsp'");
			out.println("</script>");
		}
	}

}
