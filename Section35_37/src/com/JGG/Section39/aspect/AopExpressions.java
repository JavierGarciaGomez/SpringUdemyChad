package com.JGG.Section39.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//336
@Aspect
public class AopExpressions {
    //331
    @Pointcut("execution(* com.JGG.Section39.DAO.*.*(..))")
    private void forDaoPackage(){

    }



}
