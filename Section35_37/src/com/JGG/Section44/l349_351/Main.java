package com.JGG.Section44.l349_351;

import com.JGG.Section44.l349_351.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//342, 345, 348, 350
public class Main {
    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.JGG.Section44.l349_351.DemoConfig.class);
        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("*****350********* Calling fortuneService");
        System.out.println(trafficFortuneService.getFortune());


        context.close();
    }
}
