package com.self.learnFile.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component("myAdvice")
@Aspect
public class MyAdvice {
//    @Pointcut("execution(void com.self.learnFile.service.WorkServiceFramework.*(..))")
    @Pointcut("execution(* com.self.learnFile.*.*Service*.*e(..))")
    private void pointcut(){
    }

    @Pointcut("execution(* com.self.learnFile.*.*Service*.selectCount(..))")
    private void pointcut0(){
    }

    @Pointcut("execution(* com.self.learnFile.*.*Service*.selectByIdAndName(..))")
    private void pointcut1(){}

//    @Before("pointcut()")  //把切入点定义在方法之前执行
//    public void tellTime(){
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("现在时间是：" + now);
//    }

    @Around("pointcut0()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("方法开始执行...");
        Object result = pjp.proceed();
        System.out.println("方法执行完毕...");
        return result;
    }

//    @Around("pointcut()")
//    public Object around1(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("开始执行方法...");
//        pjp.proceed();
//        System.out.println("方法执行完毕...");
//        return null;
//    }

    @Around("pointcut1()")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println(pjp.getSignature().getName() + "开始执行...");
        Object[] values = pjp.getArgs();
        System.out.println(Arrays.toString(values));
        Object result = pjp.proceed(values);
        System.out.println(pjp.getSignature().getName() + "方法执行完毕...");
        return result;
    }


}
