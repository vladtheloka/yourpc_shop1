<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="<c:url value="/css/updateUser.css"/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/js/updateUser.js"/>"></script>

<div class="form-wrap">
    <div class="tabs-content">
        <div id="update-tab-content" class="active">
            <c:url var="save" value="${userAttribute.id}"/>
            <form:form modelAttribute="userAttribute" class="signup-form" action="${save}" method="post">
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off" placeholder="Email"/>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="Username"/>
                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password"/>
                <form:input path="address" type="text" class="input" id="user_address" autocomplete="off" placeholder="Address"/>
                <input type="submit" class="button" value="Save">
            </form:form>
        </div>
    </div>
</div>
