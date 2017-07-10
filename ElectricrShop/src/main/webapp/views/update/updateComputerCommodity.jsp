<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Computer commodity update</title>

	<c:url var="saveUrl"
		value="/updateCommodity/${commodityUpdate.id}?${_csrf.parameterName}=${_csrf.token}"/>
	<sf:form modelAttribute="commodityUpdate" method="post" enctype="multipart/form-data"
		action="${saveUrl}">
		<table>
			<tr>
				<td><sf:label path="price">Commodity price</sf:label></td>
				<td><sf:input path="price" required="required"/></td>
			</tr>
			<tr>
				<td><sf:label path="model">Commodity model</sf:label></td>
				<td><sf:input path="model"/></td>
			</tr>
			<tr>
				<td><sf:label path="number">Commodity number</sf:label></td>
				<td><sf:input path="number" required="required"/></td>
			</tr>
			<tr>
				<td><sf:label path="maker">Commodity maker</sf:label></td>
				<td><sf:select path="maker" items="${makers}" itemLabel="name" itemValue="id"/></td>
			</tr>
			<tr>
				<td><sf:label path="categories">Commodity category</sf:label></td>
				<td><sf:select path="categories" items="${categories}" itemLabel="Category" itemValue="id"/></td>
			</tr>

			<tr>
				<td><sf:label path="computerPathImage">Commodity image</sf:label></td>
				<td><input name="computerImage" type="file"></td>
			</tr>
			<tr>
				<td><sf:label path="computerPathImage">Image:</sf:label></td>
				<td><img src="/${computerCommodityUpdate.computerPathImage}" alt=""></td>
				<td><sf:input type="hidden" path="computerPathImage"/></td>
			</tr>
		</table>
		<button>Update</button>
	</sf:form>
	<br>
	<a href="/addComputerCommodity"><button>Back</button></a>
