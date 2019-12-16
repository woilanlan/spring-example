<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: longlong
  Date: 2019/12/15
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello,ssm</h1>
    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>作者</td>
        </tr>
        <c:forEach items="${bs}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.b_name}</td>
                <td>${b.author}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
