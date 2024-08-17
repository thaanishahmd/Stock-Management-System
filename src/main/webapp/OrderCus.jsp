<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<%
	String username=request.getParameter("username");
	String pname=request.getParameter("p_name");
%>
	<form action="addcusorder?username=<%out.print(username);%>" method="post" class="form">
<%-- 	<a href="homeview3?username=<%out.print(username);%>"><< Home</a> --%>
		<h2>Order</h2><br>
      <div class="reg">
        <center>
        <label for="pname">Product:</label>
        <input type="text" name="product" value="<%out.print(pname);%>" readonly>
		<input type="text" name="p_quantity" placeholder="Product Quantity">
		<input type="text" name="c_name" value="<%out.print(username);%>" readonly>
		<input type="text" name="c_phone" placeholder="Enter Mobile Number">
		</center>
        <button type="Submit">Order</button>
        </div>
     </form>
</body>
</html>