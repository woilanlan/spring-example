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
public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 请求首先会到达这里
     * @return 返回值为true，表示允许请求继续向下走，返回值为false，表示请求到此为止
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        System.out.println("preHandle-2");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle-2");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion-2");
    }
}
