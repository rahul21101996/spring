<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of Products</h2>
<table border='2'>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Price</th>
<th>Modify Product</th>
</tr>
<c:forEach var="p" items="${plist}">
<tr>
<td>${p.pid}</td>
<td>${p.pname}</td>
<td>${p.price}</td>
<td>
<a href="editproduct/${p.pid}">edit/</a>
<a href="deleteproduct/${p.pid}">delete</a>
</td>
</tr>
</c:forEach>


</table>
<a href="showform">Add Product</a>
</body>
</html>