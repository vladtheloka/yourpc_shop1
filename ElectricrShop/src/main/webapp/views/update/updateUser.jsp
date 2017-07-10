<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.05.2017
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<title>Update User</title>

	<c:url var="saveUrl" value="/updateUser/${userAttribute.id}"></c:url>
	<sf:form modelAttribute="userAttribute" method="post"
		action="${saveUrl}">
 		<p style="color: red">${usernameupdateExeption}</p>
		<p style="color: red">${emailupdateException}</p>
		<p style="color: red">${passwordupdateException}</p> 

		<table>
			<tr>
				<td><sf:label path="name">User name</sf:label></td>
				<td><sf:input path="name"></sf:input></td>
			</tr>
			<tr>
				<td><sf:label path="email">User email</sf:label></td>
				<td><sf:input path="email"></sf:input></td>
			</tr>
			<tr>
				<td><sf:label path="password">User password</sf:label></td>
				<td><sf:input path="password"></sf:input></td>
			</tr>


		</table>
		<button>Update</button>

	</sf:form>
	<br>
	<a href="/FormAddUserAndUpdate"><button>Back</button></a>


