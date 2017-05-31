<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
            <form:form id="myForm" modelAttribute="user" method="post" action="/saveUser">
                <table>
                    <tr>
                        <td><form:label path="name">Name:</form:label></td>
                        <td><form:input path="name"/></td>
                        <td style="color: red">${usernameException}</td>
                    </tr>

                    <tr>
                        <td><form:label path="email">Email:</form:label></td>
                        <td><form:input path="email"/></td>
                        <td style="color: red">${emailException}</td>
                    </tr>

                    <tr>
                        <td><form:label path="password">Password:</form:label></td>
                        <td><form:password path="password"/></td>
                        <td style="color: red">${passwordException}</td>
                    </tr>

                    <tr>
                        <td><form:label path="address">Address:</form:label></td>
                        <td><form:input path="address"/></td>
                        <td style="color: red">${addressException}</td>
                    </tr>
                    
                    <tr>
                        <td><form:label path="role">Role:</form:label></td>
                        <td><form:checkboxes path="role" items="${roles}" itemLabel="name" itemValue="id"/></td>
                    </tr>
                </table>
                <input type="submit" value="Save" />
            </form:form>
</body>
</html>