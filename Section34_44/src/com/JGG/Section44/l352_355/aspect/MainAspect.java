package com.JGG.Section44.l352_355.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

//351,355
@Aspect
@Component
@Order(27)
public class MainAspect {
    //352
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //351
    @Around("execution(* com.JGG.Section44.l352_355.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("351-- Executing @Around on method: "+method);
        // get begin timestam
        long begin = System.currentTimeMillis();
        // execute the method
        //354 changes
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            myLogger.warning(e.getMessage());
            result="354. Major accident, dont worry. Sending a helicopter";
        }
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        myLogger.info("351-- The duration was: "+duration/1000.0+" seconds");
        return result;
    }

}
