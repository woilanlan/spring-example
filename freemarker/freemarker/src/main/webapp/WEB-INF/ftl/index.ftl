<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>hello freemarker!</h1>
<h2>${root}</h2>
<hr>
<p style="color: blue">插值规则</p>
${name}<br>
${age}<br>
${enabled?string("true","false")}<br>
${birthday?string("yyyy-MM-dd")}<br>
<hr>
<#assign price=99.8888>
${price?string["0.##"]}
<hr>
${'hello freemark'}
<hr>
<#list ['a','b','c','d'] as x>
    ${x}<br>
</#list>
<hr>
<p style="color: blue">输出变量list和map</p>
<table border="1">
    <tr>
        <td>书名</td>
    </tr>
    <#list bs as b>
        <tr>
            <td>${b}</td>
        </tr>
    </#list>
</table>
<hr>
${books.id}<br>
${books.name}<br>
${books["author"]}<br>
<hr>
${books.book2.id}<br>
${books.book2.name}<br>
${books.book2.author}<br>
</body>
</html>