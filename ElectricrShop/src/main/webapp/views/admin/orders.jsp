<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders Menu</title>

	<div style="text-align: center; margin-top: 10%">
		<form action="/addOrder" method="post">
			<input type="text" name="OrderDate"> 
			<br>
			<button>addOrder</button>
		</form>
	</div>
	<ol>
	<c:forEach var="orders" items="${ordersList}" >
	<li>${orders.date }<a href="/deleteOrder/${orders.id }"> delete</a></li>
	</c:forEach>
	</ol>
