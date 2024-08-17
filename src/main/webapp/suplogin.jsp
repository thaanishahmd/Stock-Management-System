<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Supplier Login</title>
</head>
<body>
	<form action="Suplog" method="post" class="form">
	<a href="StartUp.jsp"><< Main</a>
	<div class="login show-page">
	<h2>Supplier Login</h2>
		<input type="text" name="username" placeholder="Username"><br>
		<input type="password" name="password" placeholder="Password"><br>
		<button type="Submit">Login</button>
		<a href="SupRegister.jsp">Register</a>
	</div>
	</form>
</body>
</html>