<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.deliveryperson.DeliveryPerson" %>
    <%@page import="com.deliveryperson.DeliveryDBUtil" %>
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
    ArrayList<DeliveryPerson> ar=(ArrayList<DeliveryPerson>)DeliveryDBUtil.getDeliveryPerson((String)request.getAttribute("username"));
    DeliveryPerson dp=ar.get(0);
    
    String username=(String)request.getAttribute("username");  
%>

<c:forEach var="dp" items="${dpDetails}">
		<c:set var="id" value="${dp.id}"/>
		<c:set var="name" value="${dp.name}"/>
		<c:set var="email" value="${dp.email}"/>
		<c:set var="phone" value="${dp.phone}"/>
		<c:set var="username" value="${dp.username}"/>
		<c:set var="password" value="${dp.password}"/>
</c:forEach>

<form action="#" method="post" class="form">
		<h2>My Profile Details</h2>
      <div class="reg">
	<table>
		<tr>
			<td>Delivery Person ID - </td>
			<td><input type="text" name="id" value="<%out.print(dp.getId()); %>" readonly></td>
		</tr>
		<tr>
			<td>Name - </td>
			<td><input type="text" name="name" value="<%out.print(dp.getName()); %>" readonly></td>
		</tr>
		<tr>
			<td>Email - </td>
			<td><input type="text" name="email" value="<%out.print(dp.getEmail()); %>" readonly></td>
		</tr>
		<tr>
			<td>Mobile Number - </td>
			<td><input type="text" name="phone" value="<%out.print(dp.getPhone()); %>" readonly></td>
		</tr>
		<tr>
			<td>User name -  </td>
			<td><input type="text" name="un" value="<%out.print(dp.getUsername()); %>" readonly></td>
		</tr>
	</table>
	
	<c:url value="DpUpdate.jsp" var="dpupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>

	<a href="${dpupdate}">
		<input type="button" name="update" value="Edit my account" class="btn">
	</a>
	
	<c:url value="DpDelete.jsp" var="dpdelete">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone_num" value="${phone}"/>
		<c:param name="usrname" value="${username}"/>
		<c:param name="pwd" value="${password}"/>
	</c:url>
	<a href="${dpdelete}">
		<input type="button" name="delete" value="Delete my account" class="btn">
	</a>
	<a href="homeview4?username=<%out.print(username);%>">
		<input type="button" name="delete" value="Home" class="btn">
	</a>
 </div>
     </form>

</body>
</html>