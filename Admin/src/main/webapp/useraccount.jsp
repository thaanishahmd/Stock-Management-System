<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	
		table, th, td {
  			border: 1px solid black;
		}
	</style>
</head>
<body>

	<table>
	
	<c:forEach var="a" items="${aDetails}">
	
	<c:set var="id" value="${a.id}"/>
	<c:set var="name" value="${a.name}"/>
	<c:set var="email" value="${a.email}"/>
	<c:set var="phone" value="${a.phone}"/>
	<c:set var="username" value="${a.username}"/>
	<c:set var="password" value="${a.password}"/>

	<tr>
		<td>Administrator ID</td>
		<td>${a.id}</td>
	</tr>
	<tr>
		<td>Administrator Name</td>
		<td>${a.name}</td>
	</tr>
	<tr>
		<td>Administrator Email</td>
		<td>${a.email}</td>
	</tr>
	<tr>
		<td>Administrator Phone</td>
		<td>${a.phone}</td>
	</tr>
	<tr>
		<td>Administrator User Name</td>
		<td>${a.username}</td>
	</tr>
	<tr>
		<td>Administrator Password</td>
		<td>${a.password}</td>
	</tr>
	</c:forEach>
	</table>
	</body>
	</html>