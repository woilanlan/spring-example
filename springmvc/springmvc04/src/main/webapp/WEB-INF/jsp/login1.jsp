<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lymatrix
  Date: 2019/10/24
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录1</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/doLogin1" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" value="${use.username}">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password" value="${use.password}">
            </td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td>
                <select name="" id="">
                    <c:forEach items="${as}" var="a">
                        <option value="${a}">${a}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
