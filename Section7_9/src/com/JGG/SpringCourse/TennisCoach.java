package com.JGG.SpringCourse;

import org.springframework.stereotype.Component;

//54
@Component("thatSillyCoach")
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your tennis shoot";
    }
}