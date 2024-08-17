<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
	<%
		String pid=request.getParameter("p_id");
		String pname=request.getParameter("p_name");
		String pdesc=request.getParameter("p_desc");
		String pprice=request.getParameter("p_price");
		String category=request.getParameter("p_cate"); 
		String username=request.getParameter("username");
	%>
	<form action="delprod?username=<%out.print(username);%>" method="post" class="form">
	<h2>Delete Product</h2>
     	<div class="reg">
	      	<input type="text" name="pid" value="<%= pid %>" readonly>
	        <input type="text" name="pname" value="<%= pname %>" readonly>
	        <input type="text" name="pdesc" value="<%= pdesc %>" readonly>
	        <input type="text" name="pprice" value="<%= pprice %>" readonly>
	        <input type="text" name="cate" value="<%= category %>" readonly>
	        <button type="Submit">Delete Product</button>
        </div>
    </form>
</body>
</html>