package com.JGG.Section38.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//331
@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice

    //331
    @Pointcut("execution(* com.JGG.Section38.DAO.*.*(..))")
    private void forDaoPackage(){
        System.out.println("331. EXECUTING INSIDE THE POINTCUT");
    }

    //331
    @Before("forDaoPackage()") // before the pointcut
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> 331. Executing @Before any Method with any parameters");
    }

    //331
    @Before("forDaoPackage()")
    public void performApiAnalyitics(){
        System.out.println("\n======>>> 331. Performing API ANALYTICS");
    }

    //334 create pointcut for setter
    @Pointcut("execution(* com.JGG.Section38.DAO.*.set*(..))")
    private void setterMethods(){
    }
    //334 create pointcut for include but exclude setter
    @Pointcut("forDaoPackage()&&!setterMethods()")
    public void forDaoPackageExcludingSetter() {}

    //334
    @Before("forDaoPackageExcludingSetter()")
    public void beforeDaoPackageExcludingSetter(){
        System.out.println("\n======>>> 334. Print before methods excluding setters");
    }


}
