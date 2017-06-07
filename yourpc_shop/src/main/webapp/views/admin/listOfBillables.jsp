<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div class="container">

        <form action="<c:url value="/billable"/>">
            <input type="submit" value="Add Billable" />
        </form>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
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
                    <td><c:out value="${billable.user}" /></td>
                    <td><c:out value="${billable.item}" /></td>
                    <td><a href="/deleteBillable/${billable.id}">Delete</a></td>
                    <td><a href="/updateBillable/${billable.id}">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
