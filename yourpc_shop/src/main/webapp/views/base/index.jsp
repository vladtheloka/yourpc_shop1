<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Item Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Content</th>
                <th>Category</th>
                <th colspan=2>Action</th>
                <%--<th>--%>
                    <%--<li>--%>
                        <%--<div class="form-group; col-lg-10">--%>
                            <%--<label class="sr-only" for="search">Email address</label>--%>
                            <%--<input type="text" class="form-control" id="search"--%>
                                   <%--placeholder="search"/>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                <%--</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${items}" var="item">
            <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><c:out value="${item.content}" /></td>
            <td><c:out value="${item.category}" /></td>
            <td><a href="/deleteItem/${item.id}">Delete</a></td>
            <td><a href="/updateItem/${item.id}">Update</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>