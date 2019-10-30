# springmvc学习案例

## springmvc01

1. springmvc简介
2. 前端控制器：DispatcherServlet
3. 请求映射器：BeanNameUrlHandlerMapping
4. 请求处理适配器：SimpleControllerHandlerAdapter
5. 处理器：Bean实现Controller接口
6. 配置请求映射：
7. 配置视图解析器

## springmvc02

1. RequestMappingHandlerMapping和RequestMappingHandlerAdapter
2. 注解@Controller
3. 注解@RequestMapping
4. 方法返回值为void时

    - 默认去查找方法同名的页面作为方法的视图返回
    - 加上@ResponseBody注解后，增加参数HttpServletResponse和HttpServletRequest
    - 服务器端跳转
    - 返回json数据
  
5. 方法返回值为字符串

   - 返回字符串
   - 逻辑视图名
   - 请求转发或跳转

6. 默认支持的参数类型

## springmvc03

参数类型为

1. 简单数据类型
2. 对象参数
3. 配置参数类型转换
4. 设置请求和响应编码格式

## springmvc04

1. 集合类型参数：数组、List、Map
2. 文件上传
3. 静态资源过滤
4. 服务器端校验
   1. 分组校验
5. 数据回显
   1. @ModelAttribute
6. 异常处理
7. 响应json
   1. HttpMessageConverter
   2. 配置 FastJsonHttpMessageConverter
8. 请求参数为json
   1. 在Servlet中通过流的方式获取json数据
   2. 在springmvc中，使用注解 @RequestBody 直接接收json参数

## springmvc05

在RESTful中
1、一个URL操作一个资源
2、请求的URL中不能有动词
3、使用HTTP的请求方式来描述请求行为。例如：
GET	查	http://localhost:8080/book/1	查询id为1的书
POST	增	http://localhost:8080/book/1	添加一本书，书的id为1
DELETE	删	http://localhost:8080/book/1	删除id为1的书
PUT	改	http://localhost:8080/book/1	修改id为1的书

Spring容器和SpringMVC容器的关系：
Spring容器是一个父容器，SpringMVC容器是一个子容器，它继承自Spring容器，因此,在SpringMVC容器中，可以访问到Spring容器中定义的Bean,而在Spring容器中，无法访问SpringMVC容器中定义的Bean。在Web开发中，Controller全部在SpringMVC中扫描，除了Controller之外的Bean,全部在Spring容器中扫描（Service、Dao），按这种方式扫描，扫描完成后，Controller可以访问到Service

1、为什么不全部都在Spring中扫描？
因为处理映射器只会去SpringMVC中查找到Controller，如果没有，就找不到，不会去Spring中找，这就决定了，Controller必须在SpringMVC中扫描

2、为什么不全部在SpringMVC中扫描
在SSM整合或者Spring+SpringMVC+JdbcTemplate中，可以全部在SpringMVC中扫描，但是，在SSH整合中，这种方式不允许。

最佳实践：
1、Controller在SpringMVC中扫描、视图解析器等在SpringMVC容器中配置
2、Spring中扫描Service、Dao以及其他组件，事务定义、数据源定义都在Spring容器中配置
