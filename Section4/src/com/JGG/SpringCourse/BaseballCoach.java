package com.JGG.SpringCourse;

public class BaseballCoach implements Coach {
    //19
    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getPresentation() {
        return "Hello, I'm your BASEBALL COACH";
    }



    //31 Define a private field
    private FortuneService fortuneService;

    // 31 define a constructor
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public BaseballCoach() {
    }

    //31
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
