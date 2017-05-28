<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table border=1 align="center" style="text-align: center">
    <thead>
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Address</th>
        <th>Role</th>
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
            <td><c:out value="${user.role}" /></td>
            <td><a href="/deleteUser/${user.id}">Delete</a></td>
            <td><a href="/updateUser/${user.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p align="center"><a href="signup">Add User</a></p>
<table border=1 align="center" style="text-align: center;">
    <thead>
    <tr>
        <th>Role Id</th>
        <th>Name</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><c:out value="${role.id}" /></td>
            <td><c:out value="${role.name}" /></td>
            <td><a href="/deleteRole/${role.id}">Delete</a></td>
            <td><a href="/updateRole/${role.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p align="center"><a href="role">Add Role</a></p>
<table border=1 align="center" style="text-align: center">
    <thead>
    <tr>
        <th>Item Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Content</th>
        <th>Category</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><c:out value="${item.content}" /></td>
            <td><c:out value="${item.category}" /></td>
            <td><a href="/deleteItem/${item.id}">Delete</a></td>
            <td><a href="/updateItem/${item.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p align="center"><a href="item">Add Item</a></p>
<table border=1 align="center" style="text-align: center;">
    <thead>
    <tr>
        <th>Category Id</th>
        <th>Name</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.id}" /></td>
            <td><c:out value="${category.name}" /></td>
            <td><a href="/deleteCategory/${category.id}">Delete</a></td>
            <td><a href="/updateCategory/${category.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p align="center"><a href="category">Add Category</a></p>
<table border=1 align="center" style="text-align: center">
    <thead>
    <tr>
        <th>Billable Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>User</th>
        <th>Items</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${billables}" var="billable">
        <tr>
            <td><c:out value="${billable.id}" /></td>
            <td><c:out value="${billable.name}" /></td>
            <td><c:out value="${billable.address}" /></td>
            <td><c:out value="${billable.user}" /></td>
            <td><c:out value="${billable.item}" /></td>
            <td><a href="/deleteBillable/${billable.id}">Delete</a></td>
            <td><a href="/updateBillable/${billable.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p align="center"><a href="billable">Add Billable</a></p>
</body>
</html>