package com.JGG.Section39.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//331
@Aspect
@Component
@Order(27)
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice


    //331
    @Before("com.JGG.Section39.aspect.AopExpressions.forDaoPackage()") // before the pointcut
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> 331. Executing @Before any Method with any parameters. Order 27");
    }


    //334
    @Before("com.JGG.Section39.aspect.AopExpressions.forDaoPackageExcludingSetter()")
    public void beforeDaoPackageExcludingSetter(){
        System.out.println("\n======>>> 334. Print before methods excluding setters");
    }


}
