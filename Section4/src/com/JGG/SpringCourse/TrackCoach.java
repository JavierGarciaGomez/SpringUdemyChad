package com.JGG.SpringCourse;

//20
public class TrackCoach implements Coach {
    public TrackCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getPresentation() {
        return "Hello, I'm your TRACK COACH";
    }

    //32
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
