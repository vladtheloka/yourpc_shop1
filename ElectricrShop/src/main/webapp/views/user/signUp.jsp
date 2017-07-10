<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.05.2017
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<title>User Menu</title>
<link rel="stylesheet" href="/css/SignUp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/AddUserForm.js"></script>



<br>
<br>
<div class="form-wrap">
	<div class="tabs">
		<h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
		<h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
	</div><!--.tabs-->

	<div class="tabs-content">
		<div id="signup-tab-content" class="active">
			<sf:form modelAttribute="user" class="signup-form" method="post">
				<h3 style="text-align: center;color: red">${usernameException}</h3>
				<sf:input path="name" type="text" class="input" id="user_name" autocomplete="off"
							placeholder="Username"/>
				<h3 style="text-align: center;color: red">${emailException}</h3>
				<sf:input path="email" type="text" class="input" id="user_email" autocomplete="off"
							placeholder="Email"/>
				<h3 style="text-align: center;color: red">${passwordException}</h3>
				<sf:input path="password" type="password" class="input" id="user_pass" autocomplete="off"
							placeholder="Password"/>
				<input type="submit" class="button" value="Sign Up">
			</sf:form><!--.login-form-->
		</div><!--.signup-tab-content-->

		<div id="login-tab-content">
			<sf:form class="login-form" method="post" action="/login">
				<input name="username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Username">
				<input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
				<input type="submit" class="button" value="Login">
			</sf:form><!--.login-form-->
		</div><!--.login-tab-content-->
	</div><!--.tabs-content-->
</div>

<%--<ol style="margin-left: 25px">
	<c:forEach var="user" items="${users}">
		<li>${user.name},${user.email} <a href="/deleteUser/${user.id }"><button>
			delete</button> </a> <a href="/updateUser/${user.id}"><button>update</button></a></li>
	</c:forEach>
</ol>--%>
	<a href="/"><button>Main menu</button></a>

