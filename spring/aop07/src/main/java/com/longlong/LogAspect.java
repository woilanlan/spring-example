package com.longlong;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 这个类就是切面，该类中的内容包含两大块：切点+通知
 *
 *  @Component表示将该类注册到Spring容器中
 *  @Aspect表示该类是一个切面
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 可以单独定义一个方法，专门用来定义切点，然后再其他方法中引用
     * 使用注解
     */
    @Pointcut("@annotation(MyAction)")
    public void pointcut1(){
    }

    /**
     * 可以单独定义一个方法，专门用来定义切点，然后再其他方法中引用
     *  使用表达式，减少侵入
     *  第一个*表示目标方法的返回值，可以是任意类型。
     *  第二个*表示类中的任意方法
     *  两个.表示方法的参数任意（类型任意，可有可无）
     *
     *  例如，想精确定位到add方法，步骤如下
     *  execution(int com.longlong.MyCalculator.add(int,int))
     *
     *  service包下的所有类所有方法
     *  execution(int com.longlong.service.*.*(..))
     */
    @Pointcut("execution(* com.longlong.MyCalculator.*(..))")
    public void pointcut(){
    }

    /**
     *
     * @Before 表示这是一个前置通知,该通知会在目标方法执行前执行
     * @param point 是指连接点,从这个参数中，可以获取方法名，方法参数等信息
     */
    @Before("pointcut()")
    public void before(JoinPoint point){
        String name = point.getSignature().getName();
        System.out.println(name+"方法开始执行了...");
    }

    /**
     * @After 这是一个后置通知，后置通知在目标方法执行结束后执行
     * @param point
     */
    @After("pointcut()")
    public void after(JoinPoint point){
        String name = point.getSignature().getName();
        System.out.println(name+"这个方法执行结束了");
    }

    /**
     * 这是一个返回通知，可以获取目标方法的返回值
     * 方法中的参数名和注解中的参数名是对应的
     * 需要注意返回值的类型，返回值的类型必须是参数的类或者子类
     * @param result 参数值就是目标方法的返回值
     *
     */
    @AfterReturning(value = "pointcut()",returning = "result")
    public void returning(JoinPoint point,Object result){
        String name = point.getSignature().getName();
        System.out.println(name+"方法的返回值是："+result);
    }

    /**
     * 这是一个异常通知，该通知在方法执行跑出异常时执行
     * 如果目标方法没有异常，则通知不会被触发
     * 异常的类型必须是参数的类或者子类
     */
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void throwing(JoinPoint point,Exception e){
        String name = point.getSignature().getName();
        System.out.println(name+"方法出现异常："+e.getMessage());
    }

    /**
     * 环绕通知是上面四种通知的集大成者，这个通知包含了上面四种通知的功能
     * @param pjp 这个参数类似于Method对象
     * @return
     */
    @Around("pointcut()")
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
