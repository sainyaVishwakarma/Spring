<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/MyFirstMVC/product/updateproduct" method="post">
pid:<input type="text" name="pid" id="pid" value="${prod.pid}" readonly/><br>
pname:<input type="text" name="pname" id="pname" value="${prod.pname}"/><br>
quantity:<input type="text" name="qty" id="qty" value="${prod.qty}"/><br>
price:<input type="text" name="price" id="pid" value="${prod.price}"/><br>
<button type="submit" name="btn" >submit</button>
</form>
</body>
</html>