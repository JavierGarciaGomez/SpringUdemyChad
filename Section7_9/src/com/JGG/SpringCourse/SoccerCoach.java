package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//55 Default bean id
@Component
public class SoccerCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+"says: Practice your passes";
    }

    // 61
    private FortuneService fortuneService;

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    /*// Constructor configuring the dependency injection... Its going
     * to search for an implementation of the FortuneService (HappyFortuneService) and then inject it */
    @Autowired
    public SoccerCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}