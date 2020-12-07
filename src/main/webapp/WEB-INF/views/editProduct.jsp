<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/SpringMVCDemo/updateproduct" method="post">
Product Id:<input type="text" name="pid" value="${prod.pid}" readonly>
Product Name:<input type="text" name="pname" value="${prod.pname}">
Product Price:<input type="text" name="price" value="${prod.price}">
<button type="submit">Update</button>
</form>
</body>
</html>