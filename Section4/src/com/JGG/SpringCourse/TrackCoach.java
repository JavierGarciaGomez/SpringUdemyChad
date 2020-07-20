package com.JGG.SpringCourse;

//20
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getPresentation() {
        return "Hello, I'm your TRACK COACH";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
