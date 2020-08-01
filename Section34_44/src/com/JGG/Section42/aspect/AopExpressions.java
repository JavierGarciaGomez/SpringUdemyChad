package com.JGG.Section42.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


//336
@Aspect
public class AopExpressions {
    //331
    @Pointcut("execution(* com.JGG.Section40_41.DAO.*.*(..))")
    public void forDaoPackage(){    }

    //334 create pointcut for setter
    @Pointcut("execution(* com.JGG.Section40_41.DAO.*.set*(..))")
    private void setterMethods(){
    }
    //334 create pointcut for include but exclude setter
    @Pointcut("forDaoPackage()&&!setterMethods()")
    public void forDaoPackageExcludingSetter() {}

}
