<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>

<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type='text/javascript' src="<c:url value="/js/index.js"/>"></script>
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
</script>

<script>
    $(function(){
        $("input[type='checkbox']").change(function(){
            var item=$(this);
            if(item.is(":checked"))
            {
                window.location.href= item.data("target")
            }
        });
    });
</script>

<div class="filter">
    <ul class="filter">
        <li><span class="filter" onclick="window.location.href='/all'">All</span></li>
        <li><span class="filter" onclick="window.location.href='/cpu'">CPU</span></li>
        <li><span class="filter" onclick="window.location.href='/gpu'">GPU</span></li>
        <li><span class="filter" onclick="window.location.href='/ram'">RAM</span></li>
        <li><span class="filter" onclick="window.location.href='/psu'">PSU</span></li>
        <li><span class="filter" onclick="window.location.href='/case'">Case</span></li>
        <li><span class="filter" onclick="window.location.href='/storage'">Storage</span></li>
    </ul>
    <%--<button onclick="window.location.href='/all'">All</button>--%>
    <%--<button onclick="window.location.href='/cpu'">CPU</button>--%>
    <%--<button onclick="window.location.href='/gpu'">GPU</button>--%>
    <%--<button onclick="window.location.href='/ram'">RAM</button>--%>
    <%--<button onclick="window.location.href='/psu'">PSU</button>--%>
    <%--<button onclick="window.location.href='/case'">Case</button>--%>
    <%--<button onclick="window.location.href='/storage'">Storage</button>--%>
</div>

<div class="wrapper">
    <span><i class="cart_anchor"></i></span>

    <div class="clear"></div>
    <div class="items">
        <c:forEach items="${items.content}" var="item">
            <div class="item">
                <img src="${item.pathImage}" alt="">
                <h2><c:out value="${item.name}"/><p style="float: right">$<em>${item.price}</em></p></h2>
                <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                    <button style="margin: auto; display: block;" class="add-to-cart"
                            onclick="window.location.href='/addToCart/${item.id}'">Add to cart</button>
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
            <div class="col-md-6 col-xs-12 text-center">
                <custom:pageable page="${items}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10,20" size="${items.size}"/>
            </div>
        </div>
    </div>
</div>