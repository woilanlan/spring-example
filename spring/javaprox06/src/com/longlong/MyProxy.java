package com.longlong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    /**
     *
     * @param obj 被代理的对象
     * @return 返回值就是代理后的对象
     */
    public Object getInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 被代理的对象
             * @param method 被代理的方法
             * @param args 被代理的方法的参数
             * @return 方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("add")){
                    //加日志
                }else{
                    //不加日志
                }
                long start = System.nanoTime();
                Object invoke = method.invoke(obj, args);
                long end = System.nanoTime();
                System.out.println((end-start)/Math.pow(10,6)+"毫秒");
                return invoke;
            }
        });
    }
}
