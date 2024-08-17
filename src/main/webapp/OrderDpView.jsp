<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cus.register.DBConnect" %>
    <%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Delivery Orders</title>
</head>
<body>
	<body>
<% 
	String username=(String)request.getParameter("username");
%>
			<center><h1>Delivery Orders</h1></center>
	<a href="homeview4?username=<%out.print(username);%>">
			<input type="button" name="delete" value="<< Home" class="but1">
	</a>
		<table>
		<tr>
			<th>Order ID</th>
			<th>Product Name</th>
			<th>Product Quantity</th>
			<th>Customer Name</th>
			<th>Customer Mobile</th>
		</tr>
		
		<%
			Connection con= null;
			Statement statement = null;
			ResultSet resultSet = null;
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?user=root&password=Root@mysql");
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from orderdp");
			while(resultSet.next())
 		{%>
 		
 		<tr>
			<td><%=resultSet.getString(1) %></td>
			<td><%=resultSet.getString(2) %></td>
			<td><%=resultSet.getString(3) %></td>
			<td><%=resultSet.getString(4) %></td>
			<td><%=resultSet.getString(5) %></td>
		</tr>
		<%}%>
		</table>
</body>
</html>