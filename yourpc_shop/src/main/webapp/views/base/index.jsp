<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Item Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Content</th>
                <th>Category</th>
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
                <sec:authorize access="hasRole('ROLE_USER')">
                <td><a href="/addToCart/${item.id}">Add To Cart</a></td>
                </sec:authorize>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>