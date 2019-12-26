<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/meeting/styles/common.css"/>
</head>
<body>
<div class="page-header">
    <div class="header-banner">
        <img src="/meeting/images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>
    <div class="header-quicklink">
        欢迎您，<strong>admin</strong>
        <a href="changepassword.html">[修改密码]</a>
    </div>
</div>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            登录
        </div>
        <form action="/meeting/doLogin" method="post">
            <fieldset>
                <legend>登录信息</legend>
                <table class="formtable" style="width:50%">
                    <tr>
                        <td>账号名:</td>
                        <td>
                            <input id="accountname" name="username" type="text" />
                        </td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td>
                            <input id="new" name="password" type="password" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            ${msg!}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="登录" class="clickbutton" />
                            <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/meeting/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>