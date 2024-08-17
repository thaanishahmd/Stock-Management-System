<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Delivery Person Login</title>
</head>
<body>
	<form action="dplog" method="post" class="form">
	<a href="StartUp.jsp"><< Main</a>
	<div class="login show-page">
	<h2>Delivery Person Login</h2>
		<input type="text" name="username" placeholder="Username"><br>
		<input type="password" name="password" placeholder="Password"><br>
		<button type="Submit">Login</button>
		<a href="DpRegister.jsp">Register</a>
	</div>
	</form>
</body>
</html>