<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Time</th>
                <th>Items</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <td><c:out value="${billable.id}" /></td>
            <td><c:out value="${billable.localDateTime}" /></td>
                <td>
                    <c:forEach var="item" items="${billable.item}">
                    <c:out value="${item.name}" /><br  />
                    </c:forEach>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

