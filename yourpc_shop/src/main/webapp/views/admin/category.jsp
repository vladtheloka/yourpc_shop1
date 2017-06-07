<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="category" method="post" action="/saveCategory">
    <table>
        <tr>
            <td><form:input path="name"/></td>
            <td style="color: red">${categoryException}</td>
        </tr>
    </table>
    <button>Add Category</button>
</form:form>

