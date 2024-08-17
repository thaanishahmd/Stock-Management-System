<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.admin.Admin" %>
    <%@page import="com.admin.AdminDBUtil" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<form action="Adminlog" method="post" class="form">
	<a href="StartUp.jsp"><< Main</a>
	<div class="login show-page">
	<h2>Admin Login</h2>
	     <input type="text" name="username" placeholder="Username">
	     <input type="password" name="password" placeholder="Password">
	     <button type="Submit">Login</button>
	</div>
	</form>
</body>
</html>