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

    // 48 adding init and destryo beans methods
    // add an init method
    public void doInit(){
        System.out.println("TRACK: Im in the INIT method");
    }

    // add a destroy methods
    public void doDestroy(){
        System.out.println("TRACK: Im in the DESTROY method");
    }

}
