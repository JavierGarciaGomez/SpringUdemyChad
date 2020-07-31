package com.JGG.Section39.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//336
@Aspect
@Component
@Order(5)
public class CloudLogAsyncAspect {

    @Before("com.JGG.Section39.aspect.AopExpressions.forDaoPackageExcludingSetter()")
    public void logToCloud(){
        System.out.println("\n======>>> 331. Performing API ANALYTICS. Order 5");
    }
}
