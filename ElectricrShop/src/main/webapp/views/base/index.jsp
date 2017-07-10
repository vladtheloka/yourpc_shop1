<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<script src="/js/search.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div>
    <div style="float: right">
    <input type="text" class="form-control" id="searchIn" onkeyup="search()"
           placeholder="Search..." />
    </div>
    <div class="container">
        <p style="text-align: center; color: black; font-size: large" >All Commodityes</p>
        <table class="table table-hover" id="myTable">
            <thead>
            <tr>

                <th>Maker</th>
                <th>Image</th>
                <th>Category</th>
                <th>Model</th>
                <th>Price</th>

                <sec:authorize access="hasRole('ROLE_USER')">
                <th>Add to bucket</th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody id="searchResult">
            <c:forEach var="allCommodity" items="${allCommodyties.content}">
                <tr>
                    <td>
                            ${allCommodity.maker}
                    </td>
                    <td>
                        <img src="${allCommodity.computerPathImage}" alt="">
                    </td>
                    <td>
                            ${allCommodity.categories}
                    </td>
                    <td>
                            ${allCommodity.model}
                    </td>
                    <td>

                            ${allCommodity.price}

                    </td>

                    <sec:authorize access="hasRole('ROLE_USER')">
                    <td>
                        <a href="/addtobasket/${allCommodity.id}">Add to bucket</a>
                    </td>
                    </sec:authorize>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

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
        <div class="col-md-8 col-xs-12 text-center">
            <custom:pageable page="${allCommodyties}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
        </div>
        <div class="col-md-2 col-xs-6">
            <custom:size posibleSizes="1,2,5,10" size="${allCommodyties.size}"/>

        </div>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

