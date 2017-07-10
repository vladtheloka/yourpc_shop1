<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country Menu</title>

	<div style="text-align: center; margin-top: 10%">
		<sf:form modelAttribute="country" action="/addCountry?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<p style="color: red">	${countryException } </p>
			<sf:input path="name" type="ext" name="CountryName" placeHolder="Conutry name"/>
			<br>
			<br>
			<input type="file" name="countryImage" >
			<br>
			<button>addCountry</button>
		</sf:form>
	</div>
<div>
	<table class="table table-hover">
	<thead>
	<tr>
		<th>name</th>
		<th>image</th>
		<th>delete</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="country" items="${countries}" >
	<tr>
		<td>
			${country.name}
		</td>
		<td>
			<img src="${country.pathImage}" alt="" >
		</td>

		<td>
			<a href="/deleteCountry/${country.id }">delete</a>
		</td>
		</c:forEach>
	</tr>
	</tbody>
	</table>
</div>
	<%--<ol>
	<c:forEach var="country" items="${countries}" >

	<li><img src="${country.pathImage}" alt="" width="10%" height="20%">,${country.name }<a href="/deleteCountry/${country.id }"><button>delete</button></a></li>
	</c:forEach>
	</ol>--%>
	<a href="/"><button>Main menu</button></a>
