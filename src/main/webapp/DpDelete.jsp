<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Delete Account</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String username = request.getParameter("usrname");
	String password = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone_num");
	
	%>
	
	<form action="deldp" method="post" class="form">
		<h2>Delete my account</h2>
		<div class="reg">
		<input type="text" name="dp_id" value="<%= id %>" readonly>
		<input type="text" name="name" value="<%= name %>" readonly>
		<input type="text" name="email" value="<%= email %>" readonly>
		<input type="text" name="phone_num" value="<%= phone %>" readonly>
		<input type="text" name="usrname" value="<%= username %>" readonly>
		<input type="password" name="pwd" value="<%= password %>" readonly>
		
		<button type="submit">Delete</button>
		</div>
	</form>
</body>
</html>