<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<table align="center" border="1" cellspacing="0" width="500px">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>price</td>
			<td>edit</td>
			<td>delete</td>
		</tr>
		
		<s:iterator value="productList" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td><a href="edit?product.id=${product.id}">edit</a></td>
				<td><a href="delete?product.id=${product.id}">delete</a></td>
			</tr>
		</s:iterator>
	</table>
	<br>
	<form action="add" method="post">
		<table align="center" border="1" cellspacing="0">
			<tr>
				<td>name: </td>
				<td><input type="text" name="product.name" value=""></td>
			</tr>
			<tr>
				<td>price: </td>
				<td><input type="text" name="product.price" value="0"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>