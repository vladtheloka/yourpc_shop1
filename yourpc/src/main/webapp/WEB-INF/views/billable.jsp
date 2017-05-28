<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="billable" method="post" action="/saveBillable">
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="address">Adress:</form:label></td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td><form:label path="user">User:</form:label></td>
            <td><form:select path="user" items="${users}" itemLabel="name" itemValue="id"/></td>
        </tr>

        <tr>
            <td><form:label path="item">Items:</form:label></td>
            <td><form:select multiple="true" path="item" items="${items}" itemLabel="name" itemValue="id"/></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>