<%--
  Created by IntelliJ IDEA.
  User: Klaus Yan
  Date: 3/10/2023
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${status == 1}">
        fafafa
    </c:if>

    <c:if test="${status == 0}">
        ononon
    </c:if>
</body>
</html>
