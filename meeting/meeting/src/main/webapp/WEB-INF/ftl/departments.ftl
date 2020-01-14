<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/meeting/styles/common.css"/>
    <script src="/meeting/jquery.js" type="text/javascript"></script>
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
            人员管理 > 部门管理
        </div>
        <form action="/meeting/dep" method="post">
            <fieldset>
                <legend>添加部门</legend>
                部门名称:
                <input type="text" id="departmentname" name="depName" maxlength="20"/>
                <input type="submit" class="clickbutton" value="添加"/>
            </fieldset>
            <div>${msg!}</div>
        </form>
        <table class="listtable">
            <caption>所有部门:</caption>
            <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
            <#if departments?? && (departments?size>0)>
                <#list departments as dep>
                    <tr>
                        <td>${dep.departmentid}</td>
                        <td id="td_${dep.departmentid}">${dep.departmentname}</td>
                        <td>
                            <a id="edit_${dep.departmentid}" class="clickbutton" href="#" onclick="showEditView(${dep.departmentid})">编辑</a>
                            <a id="confirm_${dep.departmentid}" class="clickbutton" href="#" onclick="doUpdate(${dep.departmentid})" style="display: none">确定</a>
                            <a id="cancel_${dep.departmentid}" class="clickbutton" href="#" onclick="cancel(${dep.departmentid},'${dep.departmentname}')" style="display: none">取消</a>
                            <a id="delete_${dep.departmentid}" class="clickbutton" href="/meeting/dep?id=${dep.departmentid}">删除</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/meeting/images/footer.png" alt="CoolMeeting"/>
</div>
<script type="text/javascript">
    function showEditView(id) {
        var el = $("#td_"+id);
        var oldDep = el.html();
        el.html("<input type='text' value='"+oldDep+"' />");
        btnSwitch(0,id);
    }
    function doUpdate(id) {
        // var el = $("#td_"+id);
        // var children = el.children();
        // alert(JSON.stringify(children));
        // $("#td_"+id).children()[0].value;

        var el = $("#td_"+id+" > input");
        $.post("/meeting/updateDep",{departmentid:id,departmentname:el.val()},function (msg) {
            //刷新页面
            if (msg.status == 200) {
                window.location.href = '/meeting/departments';
            }else{
                alert("修改失败");
            }
        });
    }
    function cancel(id,name) {
        var el = $("#td_"+id);
        el.html(name);
        btnSwitch(1,id);
    }

    function btnSwitch(i,id) {
        var editBtn = $("#edit_"+id);
        var confirmBtn = $("#confirm_"+id);
        var cancelBtn = $("#cancel_"+id);
        var deleteBtn = $("#delete_"+id);
        if(i == 0){
            // editBtn.css("display","none");
            // confirmBtn.css("display","inline");
            editBtn.hide();
            confirmBtn.show();
            cancelBtn.show();
            deleteBtn.hide();
        }else if(i == 1){
            editBtn.show();
            confirmBtn.hide();
            cancelBtn.hide();
            deleteBtn.show();
        }
    }
</script>
</body>
</html>