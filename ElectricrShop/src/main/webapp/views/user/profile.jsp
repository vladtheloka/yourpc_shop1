<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18.06.2017
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">



    <table class="table table-hover">

        <P>${user.name}</P>

        <tbody>
        <c:forEach var="commodity" items="${userBasket.commodities}">
            <tr>
                <td>
                        ${commodity.model}
                </td>
                <td>
                        ${commodity.price}
                </td>
                <td>
                    <a href="deleteFromBasket/${userBasket.id}/${commodity.id}">delete</a>
                </td>
                <td>

                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <form:form action="/buy" method="post">

    <button>buy</button>

    </form:form>

</div>
