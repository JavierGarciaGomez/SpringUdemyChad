package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//54
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your tennis shoot";
    }

    // 61
    private FortuneService fortuneService;

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    /*// Constructor configuring the dependency injection... Its going
    * to search for an implementation of the FortuneService (HappyFortuneService) and then inject it */
/*
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
*/
}