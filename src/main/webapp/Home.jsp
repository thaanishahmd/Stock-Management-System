<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<% 
	String username=(String)request.getAttribute("username");
%>

	
	<div align = center>
	<h1>Home Page </h1> 
		<h2>Hello <%out.print(username); %></h2><br>
		<%
			if(session.getAttribute("cususer")!=null){
		%>
			<a href="Cusprofile?username=<%out.print(username);%>">
				<input type="button" name="profile" value="My profile" class="button">
			</a>
			<br><br>
			<a href="ViewProduct.jsp?username=<%out.print(username);%>">
				<input type="button" name="product" value="View Products" class="button">
			</a>
			<br><br>
		<%
			}
		%>
		
		<%
			if(session.getAttribute("supuser")!=null){
		%>
			<a href="Supprofile?username=<%out.print(username);%>">
				<input type="button" name="profile" value="My profile" class="button">
			</a>
			<br><br>
			<a href="OrderSupView.jsp?username=<%out.print(username);%>">
				<input type="button" name="profile" value="View Orders" class="button">
			</a>
			<br><br>
		<%
			}
		%>
		<%
			if(session.getAttribute("adminuser")!=null){
		%>
			<a href="ViewProduct.jsp?username=<%out.print(username);%>">
				<input type="button" name="product" value="Products" class="button">
			</a>
			<br><br>
			<a href="ViewCustomer.jsp?username=<%out.print(username);%>">
				<input type="button" name="viewproduct" value="Customers" class="button">
			</a>
			<br><br>
			<a href="ViewSupplier.jsp?username=<%out.print(username);%>">
				<input type="button" name="viewsupplier" value="Suppliers" class="button">
			</a>
			<br><br>
			<a href="OrderSupView.jsp?username=<%out.print(username);%>">
				<input type="button" name="profile" value="Orders" class="button">
			</a>
			<br><br>
			<a href="OrderCusView.jsp?username=<%out.print(username);%>">
				<input type="button" name="profile" value="Orders Received" class="button">
			</a>
			<br><br>
		<%
			}
		%>
		<%
			if(session.getAttribute("dpuser")!=null){
		%>
			<a href="DpProfile?username=<%out.print(username);%>">
				<input type="button" name="profile" value="My profile" class="button">
			</a>
			<br><br>
			<a href="OrderDpView.jsp?username=<%out.print(username);%>">
				<input type="button" name="profile" value="Delivery Orders" class="button">
			</a>
			<br><br>
		<%
			}
		%>
		<a href="logout">
			<input type="button" name="logout" value="Logout" class="btn">
		</a>
		<br>
	
	</div>
</body>
</html>