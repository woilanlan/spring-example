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

1. Spring容器和SpringMVC容器的关系
2. RESTful案例
3. 拦截器的使用
4. 定义db文件
