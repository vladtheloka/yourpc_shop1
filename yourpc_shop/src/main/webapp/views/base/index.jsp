<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="<c:url value="/js/index.js"/>"></script>
<script src="<c:url value="/js/search.js"/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.add-to-cart').on('click', function () {
            //Scroll to top if cart icon is hidden on top
            $('html, body').animate({
                'scrollTop': $(".cart_anchor").position().top
            });
            //Select item image and pass to the function
            var itemImg = $(this).parent().find('img').eq(0);
            flyToElement($(itemImg), $('.cart_anchor'));
        });
    });

    $(function () {
        $("#slider-range").slider({
            range: true,
            min: 0,
            max: 500,
            values: [75, 300],
            slide: function (event, ui) {
                $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
            }
        });
        $("#amount").val("$" + $("#slider-range").slider("values", 0) +
            " - $" + $("#slider-range").slider("values", 1));
    });
</script>

<div style="margin-bottom: 10px; width: 20%; float: right; padding-right: 10px">
    <%--<p>--%>
        <%--<label for="amount">Price range:</label>--%>
        <%--<input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">--%>
    <%--</p>--%>
    <%--<div id="slider-range"></div>--%>
        <input type="text" class="form-control" id="searchIn" oninput="searchItems()"
               placeholder="Search..."/>
</div>

<div class="dropdown" style="float: left; padding-left: 10px">
    <button class="dropdown-toggle; btn btn-default" data-toggle="dropdown" role="button" aria-expanded="false">
        <spring:message code="label.Categories"/>
    </button>
    <ul class="dropdown-menu" role="menu" style="margin: 1%; padding: 0; list-style: none">
        <li><span onclick="window.location.href='/all'"><spring:message code="label.All"/></span></li>
        <li><span onclick="window.location.href='/cpu'"><spring:message code="label.CPU"/></span></li>
        <li><span onclick="window.location.href='/gpu'"><spring:message code="label.GPU"/></span></li>
        <li><span onclick="window.location.href='/ram'"><spring:message code="label.RAM"/></span></li>
        <li><span onclick="window.location.href='/psu'"><spring:message code="label.PSU"/></span></li>
        <li><span onclick="window.location.href='/case'"><spring:message code="label.Case"/></span></li>
        <li><span onclick="window.location.href='/storage'"><spring:message code="label.Storage"/></span></li>
        <li><span onclick="window.location.href='/motherboard'"><spring:message code="label.Motherboard"/></span></li>
    </ul>
</div>

<div class="wrapper">
    <span><i class="cart_anchor"></i></span>

    <div class="clear"></div>
    <div id="searchDiv" class="items">
        <c:forEach items="${items.content}" var="item">
            <div class="item">
                <img src="${item.pathImage}" alt="">
                <h2><c:out value="${item.name}"/><p style="float: right">$<em>${item.price}</em></p></h2>
                <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                    <button style="margin: auto; display: block;" class="add-to-cart"
                            onclick="window.location.href='/addToCart/${item.id}'"><spring:message
                            code="label.AddToCart"/>
                    </button>
                </sec:authorize>
            </div>
        </c:forEach>
    </div>
</div>

<div class="pageable" style="display: flex; justify-content: center;text-align: center">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                            class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="name"/>
                        <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 col-xs-12 text-center">
                <custom:pageable page="${items}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10,20" size="${items.size}"/>
            </div>
        </div>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
