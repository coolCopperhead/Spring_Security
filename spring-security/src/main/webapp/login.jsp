<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
	<form action="login" method="POST">
		<table>
			<tr>user:</tr>
			<tr><input type="text" name="username"/></tr>
			
			
			<tr>Password:</tr>
			<tr><input type="text" name="Password"/></tr>
			
			<tr><input type="submit" name="submit" value="submit"/></tr>
		</table>
	</form>

</body>
</html>