<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>

<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type='text/javascript' src="<c:url value="/js/index.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('.add-to-cart').on('click',function(){
            //Scroll to top if cart icon is hidden on top
            $('html, body').animate({
                'scrollTop' : $(".cart_anchor").position().top
            });
            //Select item image and pass to the function
            var itemImg = $(this).parent().find('img').eq(0);
            flyToElement($(itemImg), $('.cart_anchor'));
        });
    });
</script>

<!-- wrapper -->
<div class="wrapper">
    <span><i class="cart_anchor"></i></span>

    <div class="clear"></div>
    <!-- items -->
        <div class="items">
        <!-- single item -->
        <c:forEach items="${items.content}" var="item">
        <div class="item">
                <img src="${item.pathImage}" alt="">
                <h2><c:out value="${item.name}"/></h2>
                <p>Price: $<em>${item.price}</em></p>
                <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                <a class="add-to-cart" href="/addToCart/${item.id}">Add To Cart</a>
                </sec:authorize>
        </div>
        </c:forEach>
    </div>
    <!--/ items -->
</div>
<!--/ wrapper -->

<div style="display: flex; justify-content: center;text-align: center">

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
            <div class="col-md-10 col-xs-12 text-center">
                <custom:pageable page="${items}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10" size="${items.size}"/>
            </div>
        </div>
    </div>
</div>