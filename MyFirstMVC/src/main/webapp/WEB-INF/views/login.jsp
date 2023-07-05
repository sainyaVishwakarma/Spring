<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<h1 style="text-align: center">Login</h1><br>
	<form action="validate" method="post" style="text-align: center">
	username: <input type="text" name="uname" id="uname"/>
	<br><br>
	password: <input type="password" name="pass" id="pass"/><br><br>
	<button type="submit" name="btn" id="btn" >Login</button>
	</form>
</body>
</html>