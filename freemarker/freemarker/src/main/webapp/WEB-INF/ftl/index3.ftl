<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>常用指令</title>
</head>
<body>
<p style="color: blue">if指令</p>
<#list gs as g>
    <#if g==1>
        男
    <#elseif g==0>
        女
    <#else>
        未知
    </#if>
    <br>
</#list>
<hr>
<p style="color: blue">switch指令</p>
<#list gs as g>
    <#switch g>
        <#case 1>男<#break>
        <#case 0>女<#break>
        <#default>未知
    </#switch>
    <br>
</#list>
<hr>
<p style="color: blue">list中的break</p>
<#list gs as g>
    <#if g==-1>
        <#break>
    <#else>
        ${g}<br>
    </#if>
</#list>
<hr>
<p style="color: blue">include指令</p>
<#include './top.ftl'>
<hr>
<p style="color: blue">escape指令</p>
<#escape x as x?html>
    ${myhtml}<br>
    ${myhtml2}<br>
</#escape>
</body>
</html>