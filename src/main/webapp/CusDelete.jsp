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
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone_num");
		String username=request.getParameter("usrname");
		String password=request.getParameter("pwd"); 
	%>
	<form action="cusdelete" method="post" class="form">
	<h2>Delete my account</h2>
     	<div class="reg">
	      	<input type="text" name="cusid" value="<%= id %>" readonly>
	        <input type="text" name="name" value="<%= name %>" readonly>
	        <input type="text" name="email" value="<%= email %>" readonly>
	        <input type="text" name="phone" value="<%= phone %>" readonly>
	        <button type="Submit">Delete</button>
        </div>
	<br>
	</form>
</body>
</html>