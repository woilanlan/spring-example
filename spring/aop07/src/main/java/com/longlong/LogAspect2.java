package com.longlong;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 这是一个Advice
 */
public class LogAspect2 {

    public void before(JoinPoint point){
        String name = point.getSignature().getName();
        System.out.println(name+"方法开始执行了...");
    }

    public void after(JoinPoint point){
        String name = point.getSignature().getName();
        System.out.println(name+"这个方法执行结束了");
    }

    public void returning(JoinPoint point,Object result){
        String name = point.getSignature().getName();
        System.out.println(name+"方法的返回值是："+result);
    }

    public void throwing(JoinPoint point,Exception e){
        String name = point.getSignature().getName();
        System.out.println(name+"方法出现异常："+e.getMessage());
    }

    public Object around(ProceedingJoinPoint pjp){
        //pjp.proceed() 就类似于method.invoke()
        try {
//            return pjp.proceed(new Object[]{1,1});

            //写在这个位置的，就是前置通知
            Object proceed = pjp.proceed();
            //写在这个位置的，就是后置通知
            return proceed;
        } catch (Throwable throwable) {
            //写在这个位置的，就是异常通知
            throwable.printStackTrace();
        }
        return null;
    }
}
