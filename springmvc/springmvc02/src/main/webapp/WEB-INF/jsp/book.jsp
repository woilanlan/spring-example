<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lymatrix
  Date: 2019/10/17
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<table>
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>作者</td>
    </tr>
    <c:forEach items="${bs}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.name}</td>
            <td>${b.author}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
