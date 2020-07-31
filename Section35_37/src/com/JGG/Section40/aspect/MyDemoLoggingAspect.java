package com.JGG.Section40.aspect;

import com.JGG.Section40.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//331
@Aspect
@Component
@Order(27)
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice


    //331, 338 JoinPoint
    @Before("com.JGG.Section40.aspect.AopExpressions.forDaoPackage()") // before the pointcut
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>> 331. Executing @Before any Method with any parameters. Order 27");

        // 338 Display the method signature
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        System.out.println("Printing the parameter... Method: "+methodSignature);

        // 339. Display the method arguments
        System.out.println("339 DISPLAYING THE ARGS");
        Object[] args = joinPoint.getArgs();
        for(Object tempArg:args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                System.out.println("name: "+((Account) tempArg).getName());
            }
        }

    }


    //334
    @Before("com.JGG.Section40.aspect.AopExpressions.forDaoPackageExcludingSetter()")
    public void beforeDaoPackageExcludingSetter(){
        System.out.println("\n======>>> 334. Print before methods excluding setters");
    }



}
