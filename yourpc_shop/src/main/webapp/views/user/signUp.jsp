<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/css/signUp.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/js/signUp.js"/>"></script>

<div style="color: red; text-align: center">${exception}</div>
<div style="color: red; text-align: center">${emailException}</div>
<div style="color: red; text-align: center">${usernameException}</div>
<div style="color: red; text-align: center">${passwordException}</div>
<div style="color: red; text-align: center">${addressException}</div>

<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" class="signup-form" method="post">
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off"
                            placeholder="Email"/>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off"
                            placeholder="Username"/>
                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off"
                            placeholder="Password"/>
                <form:input path="address" type="text" class="input" id="user_address" autocomplete="off"
                            placeholder="Address"/>
                <input type="submit" class="button" value="Sign Up">
            </form:form><!--.login-form-->
            <%--<div class="help-text">--%>
            <%--<p>By signing up, you agree to our</p>--%>
            <%--<p><a href="#">Terms of service</a></p>--%>
            <%--</div><!--.help-text-->--%>
        </div><!--.signup-tab-content-->

        <div id="login-tab-content">
            <form class="login-form" action="<c:url value="/login"/>" method="post">
                <input name="username" type="text" class="input" id="user_login" autocomplete="off"
                       placeholder="Email or Username">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off"
                       placeholder="Password">
                <input type="submit" class="button" value="Login">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form><!--.login-form-->
            <%--<div class="help-text">--%>
            <%--<p><a href="#">Forget your password?</a></p>--%>
            <%--</div><!--.help-text-->--%>
        </div><!--.login-tab-content-->
    </div><!--.tabs-content-->
</div>
<!--.form-wrap-->
