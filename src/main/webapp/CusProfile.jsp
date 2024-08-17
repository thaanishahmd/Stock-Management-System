<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cus.register.Customer" %>
    <%@page import="cus.register.CustomerDBUtil" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style2.css" rel="stylesheet" type="text/css">
<title>My Account</title>
</head>
<body>

<%
	ArrayList<Customer> ar1 =(ArrayList<Customer>)CustomerDBUtil.getCustomer((String)request.getAttribute("username"));
   	Customer cus=ar1.get(0);
   	
   	String username=(String)request.getAttribute("username");  
%>
<c:forEach var="cus" items="${CusDetails}">
		<c:set var="id" value="${cus.id}"/>
		<c:set var="name" value="${cus.name}"/>
		<c:set var="email" value="${cus.email}"/>
		<c:set var="phone" value="${cus.phone}"/>
		<c:set var="username" value="${cus.username}"/>
		<c:set var="password" value="${cus.password}"/>
</c:forEach>
<form action="#" method="post" class="form">
		<h2>My Profile Details</h2>
      <div class="reg">
	<table>
		<tr>
			<td>Customer ID - </td>
			<td><input type="text" name="id" value="<%out.print(cus.getId()); %>" readonly></td>
		</tr>
		<tr>
			<td>Name - </td>
			<td><input type="text" name="name" value="<%out.print(cus.getName()); %>" readonly></td>
		</tr>
		<tr>
			<td>Email - </td>
			<td><input type="text" name="email" value="<%out.print(cus.getEmail()); %>" readonly></td>
		</tr>
		<tr>
			<td>Mobile Number - </td>
			<td><input type="text" name="phone" value="<%out.print(cus.getPhone()); %>" readonly></td>
		</tr>
		<tr>
			<td>User name -  </td>
			<td><input type="text" name="un" value="<%out.print(cus.getUsername()); %>" readonly></td>
		</tr>
	</table>
	

	<c:url value="CusUpdate.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>

	<a href="${cusupdate}">
		<input type="button" name="update" value="Edit my account" class="btn">
	</a>
	
	<c:url value="CusDelete.jsp" var="cusdelete">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>
	<a href="${cusdelete}">
		<input type="button" name="delete" value="Delete my account" class="btn">
	</a>
	<a href="homeview?username=<%out.print(username);%>">
		<input type="button" name="delete" value="Home" class="btn">
	</a>
	
 </div>
     </form>
</body>
</html>