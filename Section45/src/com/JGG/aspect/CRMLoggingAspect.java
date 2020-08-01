package com.JGG.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.JGG.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.JGG.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.JGG.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // Combining pointcut
    @Pointcut("forDaoPackage()||forControllerPackage()||forServicePackage()")
    private void forAppFlow() {
    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("358. in @Before: calling method: " + method);
        // Get the arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArgs : args) {
            logger.info("359. in @Before getting the args" + tempArgs);
        }
    }

    //add @After Returning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("359. in @AfterReturning: calling method: " + method);
        logger.info("359. The RESULT: "+result);
    }
}
