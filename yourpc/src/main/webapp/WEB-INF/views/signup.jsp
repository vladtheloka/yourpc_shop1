<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center; margin-top: 10%">
		
		<form action="/saveUser" method="post">
			<input type="text" name="username" placeholder="username">
			<br>
			<br>
			<input type="email" name="useremail" placeholder="email">
			<br>
			<br>
			<input type="password" name="userpassword" placeholder="password">
			<br>
			<br>
			<input type="text" name="useraddress" placeholder="address">
			<br>
			<button>Save User</button>
		</form>
		
			
</div>
</body>
</html>