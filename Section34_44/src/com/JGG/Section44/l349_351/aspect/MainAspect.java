package com.JGG.Section44.l349_351.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//351
@Aspect
@Component
@Order(27)
public class MainAspect {

    //351
    @Around("execution(* com.JGG.Section44.l349_351.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("351-- Executing @Around on method: "+method);
        // get begin timestam
        long begin = System.currentTimeMillis();
        // execute the method
        Object result = proceedingJoinPoint.proceed();
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        System.out.println("351-- The duration was: "+duration/1000.0+" seconds");
        return result;
    }

}
