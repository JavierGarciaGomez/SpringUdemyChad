package com.JGG.SpringCourse;

import org.springframework.stereotype.Component;

//55 Default bean id
@Component
public class SoccerCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+"says: Practice your passes";
    }
}