package com.longlong.interceptor;

import com.google.gson.Gson;
import com.longlong.bean.RespBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义的拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 请求首先会到达这里
     * @return 返回值为true，表示允许请求继续向下走，返回值为false，表示请求到此为止
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        System.out.println("preHandle");

        String login = req.getParameter("login");
        if(login != null && "zhangsan".equals(login)){
            return true; //有login参数，且login参数值为 zhangsan，即认为这是一个合法请求，返回true表示让请求继续往下走
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RespBean respBean = RespBean.error("请求不合法");
        out.write(new Gson().toJson(respBean));
        out.flush();
        out.close();
        return false;   //表示请求到此为止，不会继续向下执行(Controller中的方法不会被执行)
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
