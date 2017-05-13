<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center; margin-top: 10%">
	<form action="newUser" method="post">
		Name:<input type="text" placeholder="Enter your name" name="username">
		<br>
		Email:<input type="email" placeholder="Enter email" name="useremail">
		<br>
		Password:<input type="password" placeholder="Enter password" name="userpassword">
		<br>
		Address:<input type="text" placeholder="Enter address" name="useraddress">
		<br>
		<button>Submit</button>	
	</form>
</div>
</body>
</html>