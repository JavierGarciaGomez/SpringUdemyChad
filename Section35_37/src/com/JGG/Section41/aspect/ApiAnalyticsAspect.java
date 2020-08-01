package com.JGG.Section41.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//336
@Aspect
@Component
@Order(235)
public class ApiAnalyticsAspect {
    //331
    @Before("com.JGG.Section41.aspect.AopExpressions.forDaoPackageExcludingSetter()")
    public void performApiAnalyitics(){
        System.out.println("\n======>>> 331. Performing API ANALYTICS. ORder 235");
    }
}
