<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Computer Commodity Menu</title>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div style="text-align: center; margin-top: 10%">
		<sf:form modelAttribute="commodity"  action="/Commodity?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
			<p style="color: red">${modelException}</p>
			<p style="color: red">${priceExceptio}</p>
			<p style="color: red">${numberException}</p>

			<sf:input path="price" placeHolder="Price" required="required"/>
			<br>
			<sf:input path="model" placeHolder="Model"/>
			<br>
			<sf:input path="number" placeHolder="Number" required="required"/>
			<br>
			<sf:select path="maker" items="${makers}" itemLabel="name" itemValue="id"/>
			<br>
			<sf:select path="categories" items="${categories}" itemLabel="name" itemValue="id"/>

			<input name="computerImage" type="file" class="form-control">
			<button>AddCommodity</button>
		</sf:form>
	</div>
	<ol>
		<c:forEach var="comCommodity" items="${ComComodities.content}" >
			<li>${comCommodity.model}, ${comCommodity.price }, ${comCommodity.maker}<a href="/deleteCommodity/${comCommodity.id }"><button> delete</button></a>
				<a href="/updateCommodity/${comCommodity.id}"><button>Update</button></a>
				<br>
				<br>
			</li>
		</c:forEach>
	</ol>
	<br>
	<div class="container">
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<div class="container">
	<p style="text-align: center; color: black; font-size: large" >Computer Commodity</p>

	<table class="table table-hover">
		<thead>
		<tr>
			<th>Maker</th>
			<th>Image</th>
			<th>Model</th>
			<th>Price</th>
			<th>Number</th>
		<sec:authorize access="isAuthenticated()"><th>Add To Bucket</th></sec:authorize>


		</tr>
		</thead>
		<tbody>
		<c:forEach var="comCommodity" items="${ComComodities.content}">
			<tr>
				<td>
						${comCommodity.maker}
				</td>
				<td>
					<img src="${comCommodity.computerPathImage}" alt="">
				</td>
				<td>
						${comCommodity.model}
				</td>
				<td>

						${comCommodity.price}

				</td>
				<td>

						${comCommodity.number}

				</td>
				<sec:authorize access="isAuthenticated()">
					<td>
						<a href="/addtobasket/${comCommodity.id}"> Add To Bucket</a>
					</td>
				</sec:authorize>

			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>
</div>
</div>
	<br>
	<br>

<div class="col-md-12 col-xs-12">
	<div class="row">
		<div class="col-md-2 col-xs-6">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
						class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<custom:sort innerHtml="Price asc" paramValue="price"/>
					<custom:sort innerHtml="Price desc" paramValue="price,desc"/>
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-xs-12 text-center">
			<custom:pageable page="${ComComodities}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
		</div>
		<div class="col-md-2 col-xs-6">
			<custom:size posibleSizes="1,2,5,10" size="${ComComodities.size}"/>

		</div>
	</div>
</div>
</sec:authorize>

