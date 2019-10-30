package com.longlong;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    /*
    抛出异常
     */
    @GetMapping("/index")
    public String index(Integer i) throws Exception {
        if(i == 0){
            throw new CustomException("i 不能为 0");
        }else if( i == 1){
            throw new Exception("i 不能为 1 ");
        }
        return "index";
    }

    /*
    数据回显
    默认方式类似于Servlet中的方式
    在接口中返回相关数据，在表单中填入接口中返回的数据
    */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model){
        if("zhangsan".equals(username) && "123".equals(password)){
            return "index";
        }
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "forward:/login";
    }

    /*
    使用对象接收，默认就会把这个对象放到model中去，在前端页面可以直接使用对象中的数据
    表单中对象的名字和参数的名字是一致的，不可以改变。
    如果两个名字不一致，可以使用注解 @ModelAttribute 来解决
    */
    @RequestMapping("/login1")
    public String login1(){
        return "login1";
    }

/*    @PostMapping("/doLogin1")
    public String doLogin1(User user){
        if("zhangsan".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return "index";
        }
        return "forward:/login1";
    }*/

    /*
    注解 @ModelAttribute
    1、修改参数回显变量名
    @ModelAttribute("use") 表单中就可以使用 use去访问 User对象中的数据
    2、配置全局响应值
    在当前Controller中，接口中的每一个方法都返回一个集合。
    @ModelAttribute("as") 其中的 as 就是返回数据的 key
     */
    @PostMapping("/doLogin1")
    public String doLogin1(@ModelAttribute("use") User user){
        if("zhangsan".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return "index";
        }
        //return "forward:/login1";
        return "login1";
    }

    @ModelAttribute("as")
    public List<String> getAllAddress(){
        List<String> as = new ArrayList<String>();
        as.add("深圳");
        as.add("上海");
        as.add("广州");
        as.add("北京");
        return as;
    }

    /*
    常用json库：jackson gson fastjson
    响应json
    1、添加依赖:对于 Jackson Gson 这个 json 处理依赖，直接添加即可
    除此之外，其他的 json 解析器如 fastjson 都需要手动配置 HttpMessageConverter
    查看类：GsonHttpMessageConverter 和 MappingJackson2HttpMessageConverter
    实际上，在 SpringMVC 中，是一个名叫 HttpMessageConverter 的类来提供对象到 JSON 字符串的转换的。
    而 SpringMVC 默认就提供了 Gson 和 Jackson 的 HttpMessageConverter
    2、在返回对象上添加：@ResponseBody

    查看类：RequestMappingHandlerAdapter 的属性：messageConverters,有 Get 和 Set 方法，可以通过属性注入
    在 mvc:annotation-driven 中有 mvc:message-converters 标签来配置

    默认情况下，JSON处理的 HttpMessageConverter 在 AllEncompassingFormHttpMessageConverter 类中，
    如果当前项目的 classpath 下有 jackson 或者 gson 的依赖，则该类会被自动加载。然后创建相应的 HttpMessageConverter
    对于 fastjson ，由于系统未提供自动支持，因此需要开发者手动配置 FastJsonHttpMessageConverter

    HttpMessageConverter作用：
    将请求结果转为json;
    将浏览器发送来的json转为对象
     */
    @GetMapping("/user")
    @ResponseBody
    public User getUser(){
        User user = new User();
        List<String> favorites = new ArrayList<String>();
        favorites.add("足球");
        favorites.add("篮球");
        user.setFavorites(favorites);
        user.setUsername("龙龙");
        user.setPassword("123");
        return  user;
    }

    //返回对象集合
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User e = new User();
            e.setUsername("user"+ i);
            e.setPassword("pwd"+i);
            users.add(e);
        }
        return users;
    }

    //返回一个map对线
    @GetMapping("/map")
    @ResponseBody
    public Map<String,Object> user(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username","longlong");
        map.put("password",123);
        return map;
    }

    /*
    在Servlet中通过流的方式获取json数据
    {"name":"三国演义","author":"罗贯中"}

    json只能是在请求体中，因此，json只能放在post或者put请求中，请勿使用get/delete请求去测试json参数传递
     */
    @PostMapping("/test1")
    @ResponseBody
    public void test1(HttpServletRequest req) throws IOException {
        //req.setCharacterEncoding("UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine())!= null){
            sb.append(str);
        }
        Book book = new Gson().fromJson(sb.toString(), Book.class);
        System.out.println(book);
    }

    /*
    在springmvc中，直接接收json参数，如果参数中有日期的话，不需要定义日期类型转换器，日期的转换由gson/jackson/fastjson来提供

    {"name":"三国演义","author":"罗贯中","publishDate":"2019-10-05","users":[{"username":"张三"},{"username":"李四"}]}
     */
    @PostMapping("/test2")
    @ResponseBody
    public void test2(@RequestBody Book book){
        System.out.println(book);
    }
}
