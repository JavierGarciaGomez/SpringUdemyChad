package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//75
@Component
public class TennisCoach75 implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+"says: Practice your passes";
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}