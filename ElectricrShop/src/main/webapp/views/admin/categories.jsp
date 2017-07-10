<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories Menu</title>

<h2 style="text-align: center">Categories menu</h2>
<div class="container">
    <div class="panel">
        <table class="table table-hover" style="border: hidden">
            <thead>
            <tr>
                <th>Name</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <input id="categoryName">
            <br>
            <button id="saveCategory">Save Category</button>

            <tbody id="result">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/categories.js"></script>





















<%--<div style="text-align: center; margin-top: 10%">--%>
    <%--<sf:form modelAttribute="category" action="/addCategory" method="post">--%>
        <%--<sf:input path="Category" placeHolder="Category"/>--%>
        <%--<br>--%>
        <%--<br>--%>
        <%--<button>Add Category</button>--%>
    <%--</sf:form>--%>
<%--</div>--%>

<%--<ol>
    <c:forEach var="categories" items="${allCategories}">
        <li>${categories.category }, <a href="/deleteCategory/${categories.id }">
            <button>delete</button></a></li>
    </c:forEach>
</ol>--%>



