package com.JGG.Section44.l352_355;

import com.JGG.Section44.l352_355.service.TrafficFortuneService;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//342, 345, 348, 350
public class Main {
    private static Logger myLogger=Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("*****350********* Calling fortuneService");
        myLogger.info(trafficFortuneService.getFortune());

        // 354
        boolean tripWire=true;
        String data = trafficFortuneService.getFortune(tripWire);



        context.close();
    }
}
