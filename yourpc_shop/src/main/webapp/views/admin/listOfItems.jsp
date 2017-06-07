<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div class="container">

        <form action="<c:url value="/item"/>">
            <input type="submit" value="Add Item" />
        </form>

        <table class="table table-hover">
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
    </div>
</div>