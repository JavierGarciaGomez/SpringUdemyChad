package com.JGG.SpringCourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//54 Created
public class MyAppS7 {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // get the bean
        Coach coach = context.getBean("thatSillyCoach", Coach.class);
        // call a method
        System.out.println(coach.getDailyWorkout());

        //56 default component name
        coach = context.getBean("soccerCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());

        // close
        // 61
        System.out.println(coach.getDailyFortune());
        //64 Setter injection
        coach = context.getBean("baseballCoach65", Coach.class);
        System.out.println(coach.getDailyFortune());

        context.close();

    }
}

