<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1 align="center" style="text-align: center; margin-top: 10%">
        <thead>
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><a href="/deleteUser/${user.id}">Delete</a></td>
                    <td><a href="/updateUser/${user.id}">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p align="center"><a href="/signup">Add User</a></p>
</body>
</html>