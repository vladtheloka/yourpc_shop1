<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maker Menu</title>

<h2 style="text-align: center">Maker menu</h2>
	<div style="text-align: center; margin-top: 10%">
		<sf:form modelAttribute="maker" action="/maker" method="post">
		<p style="color: red">${makerException}</p>
			<sf:input path="name" placeHolder="name"></sf:input>
			<br>
			<br>
			<sf:select path="country" items="${countries}" itemLabel="name" itemValue="id"/>
			<br>
			<br>
			<button>addMaker</button>
		</sf:form>
	</div>
	<ol>
		<c:forEach var="maker" items="${makers}">
			<li>${maker.name }, ${maker.country}<a href="/deleteMaker/${maker.id }">
					<button>delete</button></a></li>
		</c:forEach>
	</ol>
<a href="/"><button>Main menu</button></a>
