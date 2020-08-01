package com.JGG.Section41.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


//336
@Aspect
public class AopExpressions {
    //331
    @Pointcut("execution(* com.JGG.Section40.DAO.*.*(..))")
    public void forDaoPackage(){    }

    //334 create pointcut for setter
    @Pointcut("execution(* com.JGG.Section40.DAO.*.set*(..))")
    private void setterMethods(){
    }
    //334 create pointcut for include but exclude setter
    @Pointcut("forDaoPackage()&&!setterMethods()")
    public void forDaoPackageExcludingSetter() {}

}
