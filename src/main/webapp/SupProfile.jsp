<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.supplier.Supplier" %>
    <%@page import="com.supplier.SupplierDBUtil" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>My Account</title>
</head>
<body>
<%
	ArrayList<Supplier> ar1=(ArrayList<Supplier>)SupplierDBUtil.getSupplier((String)request.getAttribute("username"));
   	Supplier sup=ar1.get(0);
   	
   	String username=(String)request.getAttribute("username");  
%>

<c:forEach var="sup" items="${supDetails}">
		<c:set var="id" value="${sup.id}"/>
		<c:set var="name" value="${sup.name}"/>
		<c:set var="email" value="${sup.email}"/>
		<c:set var="phone" value="${sup.phone}"/>
		<c:set var="username" value="${sup.username}"/>
		<c:set var="password" value="${sup.password}"/>
</c:forEach>

<form action="#" method="post" class="form">
		<h2>My Profile Details</h2>
      <div class="reg">
	<table>
		<tr>
			<td>Supplier ID - </td>
			<td><input type="text" name="id" value="<%out.print(sup.getId()); %>" readonly></td>
		</tr>
		<tr>
			<td>Name - </td>
			<td><input type="text" name="name" value="<%out.print(sup.getName()); %>" readonly></td>
		</tr>
		<tr>
			<td>Email - </td>
			<td><input type="text" name="email" value="<%out.print(sup.getEmail()); %>" readonly></td>
		</tr>
		<tr>
			<td>Mobile Number - </td>
			<td><input type="text" name="phone" value="<%out.print(sup.getPhone()); %>" readonly></td>
		</tr>
		<tr>
			<td>User name -  </td>
			<td><input type="text" name="un" value="<%out.print(sup.getUsername()); %>" readonly></td>
		</tr>
	</table>
	
	<c:url value="SupUpdate.jsp" var="supupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>

	<a href="${supupdate}">
		<input type="button" name="update" value="Edit my account" class="btn">
	</a>
	
	<c:url value="SupDelete.jsp" var="supdelete">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>
	<a href="${supdelete}">
		<input type="button" name="delete" value="Delete my account" class="btn">
	</a>
	<a href="homeview2?username=<%out.print(username);%>">
		<input type="button" name="delete" value="Home" class="btn">
	</a>
 </div>
     </form>

</body>
</html>