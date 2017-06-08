<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Time</th>
                <th>User</th>
                <th>Items</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                <c:forEach items="${billables}" var="billable">
                    <td><c:out value="${billable.id}" /></td>
                    <td><c:out value="${billable.localDateTime}" /></td>
                    <td><c:out value="${billable.user.name}" /></td>
                    <td>
                    <c:forEach items="${billable.item}" var="item">
                        <c:out value="${item.name}" /><br />
                    </c:forEach>
                    </td>
                    <td><a href="/deleteBillable/${billable.id}">Delete</a></td>
                    <td><a href="/updateBillable/${billable.id}">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
