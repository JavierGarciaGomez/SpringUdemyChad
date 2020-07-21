package com.JGG.SpringCourse;

import org.springframework.stereotype.Component;

import java.util.Random;

//70
@Component
public class RandomFortuneService implements FortuneService{
    // Array of Strings
    private String[] strings = {"1. Regular day","2. Good day","3. Awful day"};

    Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(strings.length);
        return "Your random fortune is "+ strings[index];
    }
}
