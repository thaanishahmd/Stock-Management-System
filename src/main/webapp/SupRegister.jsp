<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Supplier Register</title>
</head>
<body>
	 <form action="addsup" method="post" class="form">
	 <a href="StartUp.jsp"><< Main</a>
		<h2>Supplier Register</h2>
		<div class="reg">
		<input type="text" name="name" placeholder="Name">
		<input type="text" name="email" placeholder="Email">
		<input type="text" name="phone" placeholder="Contact Number">
		<input type="text" name="uid" placeholder="User Name">
		<input type="password" name="psw" placeholder="Password">
		<button type="submit">Register</button>
		<a href="suplogin.jsp">Login</a>
		</div>
	</form>
	
</body>
</html>