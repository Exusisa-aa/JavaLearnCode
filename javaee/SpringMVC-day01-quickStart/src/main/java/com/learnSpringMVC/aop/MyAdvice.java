package com.learnSpringMVC.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAdvice")
//@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.learnSpringMVC.*.*Service*.*(..))")
    private void pt(){}

    @Pointcut("execution(* com.learnSpringMVC.*.*Service*.selectById(..))")
    private void pt0(){}

    @Around("pt()")
    public Object tellTime(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        for (int i = 0; i < 1000000; i++){
            pjp.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + "执行耗时：" + (end - start) + "毫秒");
        return result;
    }

    @Around("pt0()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object[] array = pjp.getArgs();
        array[0] = 3;
        Object result = pjp.proceed(array);
        return result;
    }
}
