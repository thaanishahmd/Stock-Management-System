<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Update account</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_num");
		String username = request.getParameter("usrname");
		String password = request.getParameter("pwd");
	%>
	
	<form action="updp" method="post" class="form">
		<h2>Edit my account</h2>
		<div class="reg">
		<input type="text" name="dp_id" value="<%= id %>" readonly>
		<input type="text" name="name" value="<%= name %>">
		<input type="text" name="email" value="<%= email %>">
		<input type="text" name="phone" value="<%= phone %>">
		<input type="text" name="uname" value="<%= username %>">
		<input type="password" name="pass" value="<%= password %>">
		
		<button type="submit">Edit</button>
		</div>
	</form>
</body>
</html>