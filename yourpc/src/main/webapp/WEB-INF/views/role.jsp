<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="role" method="post" action="/saveRole">
        <table>
            <tr>
                <td><form:input path="name"/></td>
                <td style="color: red">${roleException}</td>
            </tr>
        </table>
        <button>Add Role</button>
    </form:form>
</body>
</html>
