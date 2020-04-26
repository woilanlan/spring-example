<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index2</title>
</head>
<body>
<p style="color: blue">字符串拼接和截取</p>
${'hello '+name+' !'}<br>
${'hello ${name} !'}<br>
<hr>
${hello[0]}${hello[1]}<br>
${hello[0..2]}<br>
<hr>
<p style="color: blue">集合的连接</p>
<table border="1">
    <tr>
        <td>书名</td>
    </tr>
    <#list bs+bs2 as book>
        <tr>
            <td>${book}</td>
        </tr>
    </#list>
</table>
<hr>
<p style="color: blue">内置函数</p>
${myhtml}<br>
${myhtml?html}<br>
<hr>
${hello}<br>
${hello?cap_first}<br>
${hello?upper_case}<br>
${hello?lower_case}<br>
<hr>
<p style="color: blue">集合判空</p>
<#if mylist?? && (mylist?size >0)>
    <#list mylist as mylist>
        ${mylist}<br>
    </#list>
<#else>
    mylist为空
</#if>
<hr>
<p style="color: blue">变量判空</p>
<#if var1??>
    ${var1}
<#else>
    var1为空
</#if>
<hr>
${var1!}
<hr>
${var1!'var1为空(默认空字符串)'}
</body>
</html>