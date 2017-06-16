<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Item Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Content</th>
            <th>Category</th>
            <th>Delete from cart</th>

                <form:form action="/buy" method="post">
                    <button class="btn btn-default">buy</button>
                </form:form>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userCart.items}" var="item">
            <tr>
                <td><c:out value="${item.id}" /></td>
                <td><c:out value="${item.name}" /></td>
                <td><c:out value="${item.price}" /></td>
                <td><c:out value="${item.content}" /></td>
                <td><c:out value="${item.category}" /></td>
                <td><a href="/deleteFromCart/${userCart.id}/${item.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>