<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>

<link rel="stylesheet" href="<c:url value="/css/listOfItems.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type='text/javascript' src="<c:url value="/js/listOfItems.js"/>"></script>

<div>
    <div class="container">

        <form action="<c:url value="/item"/>">
            <input type="submit" value="Add Item"/>
        </form>


        <table id="myTable" class="table table-hover">
            <thead>
            <tr>
                <th>Item Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Content</th>
                <th>Category</th>
                <th>Image</th>
                <th colspan=2>Action</th>
                <th><input type="text" class="form-control" id="search" onkeyup="myFunction()"
                           placeholder="Search for names.."/>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${items.content}" var="item">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.content}"/></td>
                    <td><c:out value="${item.category}"/></td>
                    <td><img src="${item.pathImage}" alt=""></td>
                    <td><a href="/deleteItem/${item.id}">Delete</a></td>
                    <td><a href="/updateItem/${item.id}">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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
                <custom:size posibleSizes="1,2,5,10" size="${items.size}"/>
            </div>
        </div>
    </div>
</div>