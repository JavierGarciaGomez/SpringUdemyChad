package com.JGG.Section44.l349_351.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
//350
@Component
public class TrafficFortuneService {
    public String getFortune(){
        //simule a delay
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return a fortune
        return "350. Traffic fortune service: Expect heavy traffic this morning";

    }
}
