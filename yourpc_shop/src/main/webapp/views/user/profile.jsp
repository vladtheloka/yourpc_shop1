<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Role</th>
                <th>Billable</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td>
                    <c:forEach items="${user.billable}" var="billable">
                    <a href="/billableDetails/${billable.name}">${billable.name}</a><br />
                    </c:forEach>
                    </td>
                    <td><a href="/deleteItem/${user.id}">Delete</a></td>
                    <td><a href="/updateItem/${user.id}">Update</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
