package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//67
@Component
public class TennisCoach67 implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
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