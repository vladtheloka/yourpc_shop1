<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="fixed-header">
    <div class="container">
        <nav>
            <sec:authorize access="hasRole('ROLE_USER')">
                <a href="<c:url value="/"/>"><spring:message code="label.Home"/></a>
                <a href="<c:url value="/profile"/>"><spring:message code="label.Profile"/></a>
                <a href="<c:url value="/cart"/>"><spring:message code="label.Cart"/></a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a href="<c:url value="/signUp"/>"><spring:message code="label.Login"/></a>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="<c:url value="/listOfUsers"/>"><spring:message code="label.Users"/></a>
                <a href="<c:url value="/listOfItems"/>"><spring:message code="label.Items"/></a>
                <a href="<c:url value="/openCategoryView"/>"><spring:message code="label.Categories"/></a>
                <a href="<c:url value="/listOfBillables"/>"><spring:message code="label.Billables"/></a>
            </sec:authorize>
            <div class="dropdown" style="float: right;">
            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                <spring:message code="label.Lang"/> <span class="caret"></span> </a>
            <ul class="dropdown-menu" role="menu" style="margin: 1%; padding: 0">
                <li><span onclick="window.location.href='?lang=ua'">ua</span></li>
                <li><span onclick="window.location.href='?lang=en'">en</span></li>
            </ul>
            </div>
            <sec:authorize access="isAuthenticated()">
                <form:form action="/logout" method="post">
                    <button class="btn btn-default"><spring:message code="label.Logout"/></button>
                </form:form>
            </sec:authorize>
        </nav>
    </div>
</div>