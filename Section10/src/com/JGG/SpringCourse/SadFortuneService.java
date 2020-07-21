package com.JGG.SpringCourse;

import com.JGG.SpringCourse.FortuneService;
import org.springframework.stereotype.Component;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "SAD FORTUNE";
    }
}
