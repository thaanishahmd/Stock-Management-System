<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Edit Products</title>
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

	<form action="produpdate?username=<%out.print(username);%>" method="post" class="form">
		<h2>Update Product</h2>
     	<div class="reg">
	      	<input type="text" name="pid" value="<%= pid %>" readonly>
	        <input type="text" name="pname" value="<%= pname %>">
	        <input type="text" name="pdesc" value="<%= pdesc %>">
	        <input type="text" name="pprice" value="<%= pprice %>">
	        <center>
	        <select name="categories" id="categories">
	        	<option value="<%= category %>"><%= category %></option>
			  	<option value="Differentiated Product">Differentiated Product</option>
			  	<option value="Customized Product">Customized Product</option>
			  	<option value="Potential Product">Potential Product</option>
			  	<option value="Augmented Product">Augmented Product</option>
			</select>
			</center>
			<br>
	        <button type="Submit">Update</button>
        </div>
	</form>
</body>
</html>