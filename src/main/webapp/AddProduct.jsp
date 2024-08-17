<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
<%
	String username=request.getParameter("username");
%>
	<form action="addprod?username=<%out.print(username);%>" method="post" class="form">
		<h2>Add product</h2>
      <div class="reg">
        <input type="text" name="p_name" placeholder="Product Name">
        <input type="text" name="p_desc" placeholder="Product Description">
        <input type="text" name="p_price" placeholder="Product price">
        <center>
        <label for="cars">Category:</label><br>
        <select name="categories" id="categories">
		  <option value="Differentiated Product">Differentiated Product</option>
		  <option value="Customized Product">Customized Product</option>
		  <option value="Potential Product">Potential Product</option>
		  <option value="Augmented Product">Augmented Product</option>
		</select><br>
		</center>
		<br>
        <button type="Submit">Add Product</button>
        </div>
     </form>
</body>
</html>