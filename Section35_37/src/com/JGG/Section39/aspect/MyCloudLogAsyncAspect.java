package com.JGG.Section39.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//336
@Aspect
@Component
public class MyCloudLogAsyncAspect {
    //336 adding order
    @Before("com.JGG.Section38.aspect.MyDemoLoggingAspect.forDaoPackageExcludingSetter()")
    public void logToCloudAsync(){
        System.out.println("\n======>>> 331. Performing API ANALYTICS. THE ORDER IS 10");
    }

}
