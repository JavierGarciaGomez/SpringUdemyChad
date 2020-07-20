package com.JGG.SpringCourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        //19
        // create the object
        Coach coach =new BaseballCoach();
        // use the object
        System.out.println(coach.getDailyWorkout());

        //20
        // create the object
        Coach coach2 =new TrackCoach();
        // use the object
        System.out.println(coach2.getDailyWorkout());

        // 23
        // Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/JGG/SpringCourse/applicationContext.xml");
        // Retrieve bean from spring container
        Coach coach3 = context.getBean("myCoach", Coach.class); //"mycoach" is the id of the bean and the class
        // call methods on the bean
        System.out.println(coach3.getDailyWorkout());
        // Close the contest

        // 27 EXERCISE
        System.out.println(coach3.getPresentation());


    }
}
