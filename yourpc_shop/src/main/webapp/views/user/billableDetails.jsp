<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Items</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <td><c:out value="${billable.id}" /></td>
            <td><c:out value="${billable.name}" /></td>
            <td><c:out value="${billable.item}" /><br /></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

