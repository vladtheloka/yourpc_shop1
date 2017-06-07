<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/bootstrap/bootstrap-theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/bootstrap/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/header.css"/>">
    <script src="<c:url value="/js/header.js"/>"></script>
    <meta charset="UTF-8">
</head>
<body>
<div><tiles:insertAttribute name="header"/></div>
<div><tiles:insertAttribute name="body"/></div>
<div><tiles:insertAttribute name="footer"/></div>
</body>
</html>
