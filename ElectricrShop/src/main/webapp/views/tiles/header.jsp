<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 31.05.2017
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="local" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ElectroShop</a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/signUp" ><local:message code="label.sign_up"/></a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/addCountry" ><local:message code="label.countries"/> </a></li>
                    <li><a href="/addCategory" ><local:message code="label.categories"/> </a></li>
                    <li><a href="/maker" ><local:message code="label.maker"/> </a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="/Commodity" ><local:message code="label.computerCommodity"/></a></li>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li><a href="/profile"><local:message code="label.profile"/> </a></li>
                    </sec:authorize>
                </sec:authorize>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        <local:message code="label.lang"/> <span class="caret"></span>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=ua">Українська</a></li>
                            <li><a href="?lang=en">English</a></li>
                        </ul>
                    </a>
                </li>




                        <sec:authorize access="isAuthenticated()">
                            <li>
                    <sf:form action="/logout" method="post">
                        <button class="btn btn-default"><local:message code="label.logout"/> </button>
                    </sf:form>
                        </li>
                    </sec:authorize>

            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-6 col-xs-4">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-6 hidden-sx"></div>
    </div>
</div>
