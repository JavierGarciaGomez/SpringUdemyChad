package com.JGG.SpringCourse;

public class HappyFortuneService implements FortuneService{
    //30
    @Override
    public String getFortune() {
        return this.getClass().getSimpleName()+": Today is your lucky day";
    }
}
