package com.JGG.SpringCourse;

import java.util.Random;

public class RandomFortuneService implements FortuneService{
    private String[] strings = {
            "1. You are going to get in love",
            "2. Today You are going to die",
            "3. Your day will be boring"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(strings.length);
        String theFortune = strings[index];
        return theFortune;
    }

}

