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
<meta charset="ISO-8859-1">
<link href="css/style2.css" rel="stylesheet" type="text/css">
<title>Add Order</title>
</head>
<body>
<% 
	String username=(String)request.getParameter("username");
%>
	<form action="addsuporder?username=<%out.print(username);%>" method="post" class="form">
<%-- 	<a href="homeview3?username=<%out.print(username);%>"><< Home</a> --%>
		<h2>Add Order</h2><br>
      <div class="reg">
        <center>
        <label for="pname">Product:</label><br>
        <select name="prodname" id="prodname">
   	<%
		Connection con= null;
		Statement statement = null;
		ResultSet resultSet = null;
		con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?user=root&password=Root@mysql");
		statement = con.createStatement();
		resultSet = statement.executeQuery("select * from product");
		while(resultSet.next())
 	{%>
		  <option value="<%=resultSet.getString(2) %>"><%=resultSet.getString(2) %></option>
		  <%} %>
		</select><br>
		
		<input type="text" name="p_quantity" placeholder="Product Quantity">
		<label for="sname">Supplier:</label><br>
        <select name="supname" id="prodname">
   	<%
		Connection con1= null;
		Statement statement1 = null;
		ResultSet resultSet1 = null;
		con1= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?user=root&password=Root@mysql");
		statement1 = con.createStatement();
		resultSet1 = statement.executeQuery("select * from supplier");
		while(resultSet1.next())
 	{%>
 	<option value="<%=resultSet1.getString(2) %>"><%=resultSet1.getString(2) %></option>
 	<%} %>
 	</select><br><br>
		</center>
        <button type="Submit">Add Order</button>
        </div>
     </form>
</body>
</html>