<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p style="color: blue">宏的定义和使用</p>
<#import './02.ftl' as com>
<@com.book />
<hr>
<@com.hello '张三'></@com.hello>
<hr>
<@com.books ['朝花夕拾','骆驼祥子'] '鲁迅'>
    <p>占位符,动态的定义一段html放置到指定位置</p>
</@com.books>
</body>
</html>