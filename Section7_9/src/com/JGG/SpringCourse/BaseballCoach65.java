package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//64
@Component
public class BaseballCoach65 implements Coach {

    private FortuneService fortuneService;
    public BaseballCoach65() {
    }

    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+"says: Practice your passes";
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //64 Setter injection
/*
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
*/

    //65 Setter injection with no setter
    @Autowired
    @Qualifier("happyFortuneService")
    public void anyNameMethod(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}