<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<form:form modelAttribute="category" method="post" action="/saveCategory">
    <table>
        <tr>
            <td><form:input path="name"/></td>
            <td style="color: red">${categoryException}</td>
        </tr>
    </table>
    <button>Add Category</button>
</form:form>

