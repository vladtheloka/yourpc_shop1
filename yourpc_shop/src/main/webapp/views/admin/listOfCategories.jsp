<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div class="container">

        <form action="<c:url value="/category"/>">
            <input type="submit" value="Add Category" />
        </form>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
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
    </div>
</div>