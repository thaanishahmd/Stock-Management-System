<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Send Delivery order</title>
</head>
<body>
<%
	String pname=request.getParameter("p_name");
	int pquantity= Integer.parseInt(request.getParameter("p_quantity"));
	String username=request.getParameter("username");
	String phone=request.getParameter("phone_num");
%>

<form action="adddporder?username=<%out.print(username);%>" method="post" class="form">
<%-- 	<a href="homeview3?username=<%out.print(username);%>"><< Home</a> --%>
		<h2>Send for delivery</h2><br>
      <div class="reg">
        <center>
        <input type="text" name="product" value="<%out.print(pname);%>" readonly>
		<input type="text" name="p_quantity" value="<%out.print(pquantity);%>" readonly>
		<input type="text" name="c_name" value="<%out.print(username);%>" readonly>
		<input type="text" name="c_phone" value="<%out.print(phone);%>"readonly>
		</center>
        <button type="Submit">Send</button>
        </div>
     </form>

</body>
</html>