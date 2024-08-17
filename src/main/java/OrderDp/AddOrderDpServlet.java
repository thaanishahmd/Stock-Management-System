package OrderDp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OrderCus.OrderCusDBUtil;

@WebServlet("/AddOrderDpServlet")
public class AddOrderDpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String pname=request.getParameter("product");
		int pquantity= Integer.parseInt(request.getParameter("p_quantity"));
		String username=request.getParameter("c_name");
		String phone=request.getParameter("c_phone");
		
		boolean isTrue;
		
		isTrue = OrderDpDBUtil.insertorderdp(pname, pquantity,username,phone);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("OrderCusView.jsp?username=<%out.print(username);%>");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Order sent Unsuccessful');");
			out.println("location='OrderCusView.jsp'");
			out.println("</script>");
		}
	}

}
