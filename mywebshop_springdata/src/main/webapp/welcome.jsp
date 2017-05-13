<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">welcome</h1>
<a href="newUser">new user</a>
<br>
<table border=1>
 <thead>
 <tr>
 <th>ID</th>
 <th>Name</th>
 <th>Email</th>
 <th>Password</th>
 <th>Address</th>
 </tr>
 </thead>
 <tbody>
 <tr>
 <td>${userid}</td>
 <td>${username}</td>
 <td>${useremail}</td>
 <td>${userpass}</td>
 <td>${useraddress}</td>
 </tr>
 </tbody>
 </table>
</body>
</html>