package com.JGG.SpringCourse;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return this.getClass().getSimpleName()+" You are going to have a good day";
    }

}
