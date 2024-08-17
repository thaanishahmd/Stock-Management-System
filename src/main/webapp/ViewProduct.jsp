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
<title>Products</title>
</head>
<body>
<% 
	String username=(String)request.getParameter("username");
%>
<center><h1>Product Details</h1></center>
		<%
			if(session.getAttribute("adminuser")!=null){
		%>
			<a href="homeview3?username=<%out.print(username);%>">
				<input type="button" name="delete" value="<< Home" class="but1">
			</a>
			<a href="AddProduct.jsp?username=<%out.print(username);%>">
					<input type="button" name="addproduct" value="Add New Product" class="but1">
			</a>
		<%
			}
		%>
		<%
			if(session.getAttribute("cususer")!=null){
		%>
			<a href="homeview?username=<%out.print(username);%>">
				<input type="button" name="delete" value="<< Home" class="but1">
			</a>
		<%
			}
		%>
		<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
			<th>Product Category</th>
			
		</tr>
<%

Connection con= null;
Statement statement = null;
ResultSet resultSet = null;
con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?user=root&password=Root@mysql");
statement = con.createStatement();
resultSet = statement.executeQuery("select * from product");
while(resultSet.next())
 {%>
		
		
		<tr>
			<td><%=resultSet.getString(1) %></td>
			<td><%=resultSet.getString(2) %></td>
			<td><%=resultSet.getString(3) %></td>
			<td><%=resultSet.getString(4) %></td>
			<td><%=resultSet.getString(5) %></td>
			<%
				if(session.getAttribute("adminuser")!=null){
			%>
				<td><a href="ProdUpdate.jsp?p_id=<%=resultSet.getString(1)%>&p_name=<%=resultSet.getString(2) %>&p_desc=<%=resultSet.getString(3) %>&p_price=<%=resultSet.getString(4) %>&p_cate=<%=resultSet.getString(5) %>&username=<%out.print(username);%>" class="but2">Edit</a></td>
				<td><a href="ProdDelete.jsp?p_id=<%=resultSet.getString(1)%>&p_name=<%=resultSet.getString(2) %>&p_desc=<%=resultSet.getString(3) %>&p_price=<%=resultSet.getString(4) %>&p_cate=<%=resultSet.getString(5) %>&username=<%out.print(username);%>" class="but">Delete</a></td>
			<%
			}
			if(session.getAttribute("cususer")!=null){
				%>
					<td><a href="OrderCus.jsp?p_name=<%=resultSet.getString(2) %>&username=<%out.print(username);%>" class="but2" class="but">Order</a></td>
				<%
			}
			
		}
		%>
		</tr>
		
		
		
		</table>
		        
</body>
</html>