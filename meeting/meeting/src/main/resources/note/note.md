# note

相对路径是相对于浏览器的地址，而不是相对当前文件的路径。所以使用相对路径在服务端跳转时将会出现问题。

可以使用以项目名开头的绝对路径，配置静态资源的位置即可。

```log
如果项目部署的 Application context 为 /
则静态资源的路径为：/images/footer.png
/代表从服务器的根目录，即 http:localhost:8080/ 开始

如果项目部署的 Application context 为 /meeting
则静态资源的路径为： /meeting/images/footer.png
mvc实际上截取的是images/footer.png，然后在static目录下去查找

<mvc:resources mapping="/**" location="/static/"/>
这里的/**,作用范围或匹配规则为 /应用上下文/**
```

