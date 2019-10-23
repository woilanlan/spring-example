<%--
  Created by IntelliJ IDEA.
  User: lymatrix
  Date: 2019/10/22
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<!-- 文件上传要修改表单的 enctype="multipart/form-data" -->
<form action="${pageContext.request.contextPath}/doReg" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>兴趣爱好</td>
            <td>
                <input type="checkbox" name="favorites" value="足球">足球
                <input type="checkbox" name="favorites" value="篮球">篮球
                <input type="checkbox" name="favorites" value="乒乓球">乒乓球
            </td>
        </tr>
        <tr>
            <td>读过的书</td>
            <td>书名：<input type="text" name="books[0].name"></td>
            <td>作者：<input type="text" name="books[0].author"></td>
        </tr>
        <tr>
            <td>读过的书</td>
            <td>书名：<input type="text" name="books[1].name"></td>
            <td>作者：<input type="text" name="books[1].author"></td>
        </tr>
        <tr>
            <td>用户地址</td>
            <td>
                <input type="text" name="map['address']">
            </td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td>
                <input type="text" name="map['gender']">
            </td>
        </tr>
        <tr>
            <td>用户头像</td>
            <td>
                <input type="file" name="userface">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
