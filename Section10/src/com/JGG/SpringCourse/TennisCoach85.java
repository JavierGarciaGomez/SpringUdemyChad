package com.JGG.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//75 and 77
@Component
@Scope("singleton")
public class TennisCoach85 implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+"says: Practice your passes";
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //81 init and destroy
    @PostConstruct
    public void init(){
        System.out.println("IM IN INIT");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("IM IN DESTROY");
    }

}