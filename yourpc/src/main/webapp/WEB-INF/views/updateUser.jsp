<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:url var="save" value="${userAttribute.id}"/>
<form:form modelAttribute="userAttribute" method="post" action="${save}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
            <td style="color: red">${updatenameException}</td>
        </tr>

        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email"/></td>
            <td style="color: red">${updateemailException}</td>
        </tr>

        <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:password path="password"/></td>
            <td style="color: red">${updatepasswordException}</td>
        </tr>

        <tr>
            <td><form:label path="address">Address:</form:label></td>
            <td><form:input path="address"/></td>
            <td style="color: red">${updateaddressException}</td>
        </tr>

        <tr>
            <td><form:label path="role">Role:</form:label></td>
            <td><form:select path="role" items="${roles}" itemLabel="name" itemValue="id"/></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>