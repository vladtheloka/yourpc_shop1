<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header" role="banner">
    <nav>
        <ul>
            <li>
                <sec:authentication property="name"/>
            </li>
            <sec:authorize access="hasRole('ROLE_USER')">
            <li class="active">
                <a href="<c:url value="/"/>">Home</a>
            </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
            <li class="active">
                <a href="<c:url value="/profile"/>">profile</a>
            </li>
                <li class="active">
                    <a href="<c:url value="/cart"/>">Cart</a>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
            <li>
                <a href="<c:url value="/signUp"/>">sign up</a>
            </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li>
                <a href="<c:url value="/listOfItems"/>">items</a>
            </li>
            <li>
                <a href="<c:url value="/listOfCategories"/>">categories</a>
            </li>
            <li>
                <a href="<c:url value="/listOfBillables"/>">billables</a>
            </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <li>
                <form:form action="/logout" method="post">
                    <button class="btn btn-default">logout</button>
                </form:form>
            </li>
            </sec:authorize>
        </ul>
    </nav>
</header>
<br>
<br>
<br>
<br>
<br>