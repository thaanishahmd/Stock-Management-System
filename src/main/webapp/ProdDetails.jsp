<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style2.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>

<form action="#" method="post" class="form">
<div class="reg">
	<c:forEach var="prod" items="${prodDetails}">
		<c:set var="pid" value="${prod.pid}"/>
		<c:set var="pname" value="${prod.pname}"/>
		<c:set var="pdesc" value="${prod.pdesc}"/>
		<c:set var="pprice" value="${prod.pprice}"/>
		<c:set var="category" value="${prod.categ}"/>
	
<h2>Product Details</h2>
      
		<table>
			<tr>
				<td>Product ID - </td>
				<td><input type="text" name="pid" value="${prod.pid}" readonly></td>
			</tr>
			<tr>
				<td>Product Name </td>
				<td><input type="text" name="pname" value="${prod.pname}" readonly></td>
			</tr>
			<tr>
				<td>Product Description </td>
				<td><input type="text" name="pdesc" value="${prod.pdesc}" readonly></td>
			</tr>
			<tr>
				<td>Product Price </td>
				<td><input type="text" name="pprice" value="${prod.pprice}" readonly></td>
			</tr>
			<tr>
				<td>Category </td>
				<td><input type="text" name="pcateg" value="${prod.categ}" readonly></td>
			</tr>
		</table>
	
	<c:url value="ProdUpdate.jsp" var="postupdate">
		<c:param name="pid" value="${pid}"/>
		<c:param name="pname" value="${pname}"/>
		<c:param name="pdesc" value="${pdesc}"/>
		<c:param name="pprice" value="${pprice}"/>
		<c:param name="cate" value="${categ}"/>
	</c:url>

	<a href="${postupdate}">
		<input type="button" name="update" value="Edit product" class="btn">
	</a>
	
	<c:url value="ProdDelete.jsp" var="proddelete">
		<c:param name="pid" value="${pid}"/>
		<c:param name="pname" value="${pname}"/>
		<c:param name="pdesc" value="${pdesc}"/>
		<c:param name="pprice" value="${pprice}"/>
		<c:param name="cate" value="${categ}"/>
	</c:url>
	<a href="${proddelete}">
		<input type="button" name="delete" value="Delete product" class="btn">
	</a>
	
	<a href="AddProduct.jsp">
		<input type="button" name="delete" value="Add another product" class="btn">
	</a>
	</c:forEach>
	 </div>
     </form>
</body>
</html>