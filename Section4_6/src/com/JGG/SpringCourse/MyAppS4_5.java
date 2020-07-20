package com.JGG.SpringCourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppS4_5 {
    public static void main(String[] args) {
        //19 No beans
        // create the object
        Coach coach =new BaseballCoach();
        // use the object
        System.out.println(coach.getDailyWorkout());

        //20 No beans
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

        // 32
        Coach coach32 = context.getBean("myFortuneCoach", Coach.class); //myFortuneCoach has a constructor with fortune
        System.out.println(coach32.getClass().getSimpleName()+" says "+coach32.getDailyFortune());
        Coach coach32b = context.getBean("myFortuneTrackCoach", Coach.class);
        System.out.println(coach32b.getClass().getSimpleName()+" says "+coach32b.getDailyFortune());

        // 36
        CricketCoach coach36 = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(coach36.getClass().getSimpleName()+" says "+coach36.getDailyFortune());

        //38 Injecting values
        System.out.println(coach36.toString());

        //41 Injecting values from files
        System.out.println(coach36.getRefereeName());

/*       42. Practice Activity #2 - Dependency Injection with XML Configuration
        1. Define a new implementation for the FortuneService.
            a. When the getFortune() method is called it should return a random fortune from the array.
            b. Your fortune service should define three fortunes in an array.
        2. Inject your new dependency into your Coach implementation.
        3. Test your application to verify you are retrieving random fortunes.*/
        //41 Injecting values from files
        CricketCoach coach42 = context.getBean("cricketRandomFortune", CricketCoach.class);
        System.out.println("COACH FORTUNE: "+coach42.getDailyFortune());


    }
}
