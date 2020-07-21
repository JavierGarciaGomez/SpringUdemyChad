package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Value;

//88
public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //93
    @Value("${foo.email}")
    private String email;

    public String getEmail() {
        return email;
    }
}
