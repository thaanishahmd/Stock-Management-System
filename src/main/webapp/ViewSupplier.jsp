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
<title>Supplier</title>
</head>
<body>
<% 
	String username=(String)request.getParameter("username");
%>
	<center><h1>Supplier Details</h1></center>
	<a href="homeview3?username=<%out.print(username);%>">
			<input type="button" name="delete" value="<< Home" class="but1">
		</a>
		<table>
		<tr>
			<th>Supplier ID</th>
			<th>Supplier Name</th>
			<th>Supplier Email</th>
			<th>Supplier Mobile</th>
		</tr>
<%

Connection con= null;
Statement statement = null;
ResultSet resultSet = null;
con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?user=root&password=Root@mysql");
statement = con.createStatement();
resultSet = statement.executeQuery("select * from supplier");
while(resultSet.next())
{%>


<tr>
	<td><%=resultSet.getString(1) %></td>
	<td><%=resultSet.getString(2) %></td>
	<td><%=resultSet.getString(3) %></td>
	<td><%=resultSet.getString(4) %></td>
<%-- 	<td><a href="SupDelete.jsp?id=<%=resultSet.getString(1)%>&name=<%=resultSet.getString(2) %>&email=<%=resultSet.getString(3) %>&phone_num=<%=resultSet.getString(4) %>" class="but">Delete</a> --%>
</tr>
<%}%>
		
</table>

</body>
</html>
