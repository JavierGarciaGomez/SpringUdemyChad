package com.JGG.Section44.l352_355.service;

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

    //354
    public String getFortune(boolean tripWire) {
        //simule a delay
        if(tripWire){
            throw new RuntimeException("354. Major accident!");
        }
        return getFortune();

    }
}
