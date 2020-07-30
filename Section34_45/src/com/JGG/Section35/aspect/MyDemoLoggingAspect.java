package com.JGG.Section35.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//322: HERE IS THE @BEFORE
@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> 322. Executing @Before advice on addAccount methods");
    }

    //325 Fully Qualified class
    @Before("execution(public void com.JGG.Section35.DAO.AccountDAO.addAccount())")
    public void beforeAddAccountAdviceonAccountDAO(){
        System.out.println("\n======>>> 325. Executing @Before advice on addAccount, but just in Account DAO (FULLY QUALIFIED CALL)");
    }

    //325 Match anyclass and any method that starts with add
    @Before("execution(public void add*())")
    public void beforeMethodsThatStartsWithAdd(){
        System.out.println("\n======>>> 325. Executing @Before advice on ANY METHOD THAT STARTS WITH ADD");
    }

    //326 Match with a return type
    @Before("execution(public void add*())")
    public void beforeMethodMatchingType(){
        System.out.println("\n======>>> 326. Executing @Before advice on ANY METHOD THAT STARTS WITH ADD AND RETURNS A BOOLEAN");
    }

    //326 Match with any return type
    @Before("execution(public void add*())")
    public void beforeMethodMatchingAnyReturnType(){
        System.out.println("\n======>>> 326. Executing @Before advice on ANY METHOD THAT STARTS WITH ADD AND RETURNS ANY TYPE");
    }

    //328
    @Before("execution(* add*(com.JGG.Section35.Account))")
    public void beforeAccountMethodsWithOneParameter(){
        System.out.println("\n======>>> 328. Executing @Before any method of Account Class with one parameter");
    }

    //329
    @Before("execution(* add*(com.JGG.Section35.Account, ..))")
    public void beforeAccountMethodsWithMoreParameters(){
        System.out.println("\n======>>> 329. Executing @Before any method of Account Class with account as parameter and more parameters");
    }

    //329
    @Before("execution(* add*(..))")
    public void beforeAccountMethodsWithANYParameters(){
        System.out.println("\n======>>> 329. Executing @Before any method with any parameters");
    }

    //329
    @Before("execution(* com.JGG.Section35.aspect.*.*(..))")
    public void beforeAnyMethodOfthisPackage(){
        System.out.println("\n======>>> 329. Executing @Before beforeAnyMethodOfthisPackage");
    }





}
