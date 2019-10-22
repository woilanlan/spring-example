<%--
  Created by IntelliJ IDEA.
  User: lymatrix
  Date: 2019/10/21
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    <table>
        <tr>
            <td>编号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>出版时间</td>
            <td><input type="date" name="publish"></td>
        </tr>
        <tr>
            <td>作者姓名</td>
            <td><input type="text" name="author.name"></td>
        </tr>
        <tr>
            <td>作者年龄</td>
            <td><input type="text" name="author.age"></td>
        </tr>
        <tr>
            <td>作者性别</td>
            <td><input type="text" name="author.gender"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
