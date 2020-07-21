package com.JGG.SpringCourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//85 Created
public class MyAppS10 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = context.getBean("tennisCoach85", Coach.class);
        System.out.println("85 "+coach.getDailyFortune());

        // 89
        coach = context.getBean("swimCoach", Coach.class);
        System.out.println("89 " + coach.getDailyFortune());
        
        // 93
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println("93 " + swimCoach.getEmail());
        context.close();

    }
}

