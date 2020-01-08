<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="notifications.html">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="mybookings.html">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="mymeetings.html">我的会议</a></li>
        </ul>
    </div>
    <#if e?? && (e.role == '1') >
         <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">人员管理</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menuitem"><a href="/meeting/departments">部门管理</a></li>
                <li class="sidebar-menuitem"><a href="/meeting/register">员工注册</a></li>
                <li class="sidebar-menuitem"><a href="/meeting/approveaccount">注册审批</a></li>
                <li class="sidebar-menuitem"><a href="/meeting/searchemployees">搜索员工</a></li>
            </ul>
        </div>
    </#if>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">
            <#if e?? && (e.role == '1')>
                <li class="sidebar-menuitem"><a href="addmeetingroom.html">添加会议室</a></li>
            </#if>
            <li class="sidebar-menuitem"><a href="meetingrooms.html">查看会议室</a></li>
            <li class="sidebar-menuitem"><a href="bookmeeting.html">预定会议</a></li>
            <#if e?? && (e.role == '1')>
                <li class="sidebar-menuitem"><a href="searchmeetings.html">搜索会议</a></li>
            </#if>
        </ul>
    </div>
</div>