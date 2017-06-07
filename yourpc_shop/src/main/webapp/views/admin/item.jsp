<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="item" method="post" action="/saveItem">
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
            <td style="color: red">${itemnameException}</td>
        </tr>

        <tr>
            <td><form:label path="price">Price:</form:label></td>
            <td><form:input type="number" path="price"/></td>
            <td style="color: red">${itempriceException}</td>
        </tr>

        <tr>
            <td><form:label path="content">Content:</form:label></td>
            <td><form:input path="content"/></td>
            <td style="color: red">${itemcontentException}</td>
        </tr>

        <tr>
            <td><form:label path="category">Category:</form:label></td>
            <td><form:select path="category" items="${categories}" itemLabel="name" itemValue="id"/></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
