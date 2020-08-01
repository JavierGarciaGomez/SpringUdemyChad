package com.JGG.Section42.aspect;

import com.JGG.Section42.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//331
@Aspect
@Component
@Order(27)
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice


    //331, 338 JoinPoint
    @Before("com.JGG.Section42.aspect.AopExpressions.forDaoPackage()") // before the pointcut
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>> 331. Executing @Before any Method with any parameters. Order 27");

        // 338 Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Printing the parameter... Method: " + methodSignature);

        // 339. Display the method arguments
        System.out.println("339 DISPLAYING THE ARGS");
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                System.out.println("name: " + ((Account) tempArg).getName());
            }
        }

    }


    //334
    @Before("com.JGG.Section42.aspect.AopExpressions.forDaoPackageExcludingSetter()")
    public void beforeDaoPackageExcludingSetter() {
        System.out.println("\n======>>> 334. Print before methods excluding setters");
    }

    //342 add a new advice for@AfterReturning on findAccountsMethod
    @AfterReturning(
            pointcut ="execution(* com.JGG.Section42.DAO.AccountDAO.findAccounts(..))",
            returning ="result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("342. EXECUTING AFTERRETURNMETHOD");
        System.out.println("342. THE RESULT IS "+ result );
        //344 lets post-process the data ... let's modify it :)
        
        // convet the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("344. THE RESULT IS "+ result );
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account:result){
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    //346 afterThrowingFindAccountsAdvice
    @AfterThrowing(
            pointcut = "execution(* com.JGG.Section42.DAO.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        //print out which method We are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("346. EXECUTING AFTERRTHROWING ON METHOD: "+method);
        // log the exception
        System.out.println("346. The exception is: "+exception);
    }


}
