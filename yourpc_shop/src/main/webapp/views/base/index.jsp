<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type='text/javascript' src="<c:url value="/js/index.js"/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

<div class="wrapper">
    <span><i class="cart_anchor"></i></span>

    <div class="clear"></div>
        <div class="items">
        <c:forEach items="${items}" var="item">
        <div class="item">
            <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                <a class="add-to-cart" href="/addToCart/${item.id}"><img src="${item.pathImage}" alt=""></a>
            </sec:authorize>
            <h2><c:out value="${item.name}"/><p style="float: right">$<em>${item.price}</em></p></h2>
        </div>
        </c:forEach>
        </div>
</div>