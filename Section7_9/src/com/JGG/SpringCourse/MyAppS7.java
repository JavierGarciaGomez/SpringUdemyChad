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
        //64,65 Setter injection
        coach = context.getBean("baseballCoach65", Coach.class);
        System.out.println("65"+coach.getDailyFortune());

        //67 FieldInjection
        coach = context.getBean("tennisCoach67", Coach.class);
        System.out.println("67"+coach.getDailyFortune());

        //70 Qualifier. All the above code was setted with qualifier
        //71 Qualifier. Random All the above code was setted with qualifier

        // 75 Activity #5
/*        Practice Activity #5 - Dependency Injection with Annotations
        1. Define a new implementation for the FortuneService.
        Your fortune service should read the fortunes from a file.
        The fortune service should load the fortunes into an array
        When the getFortune() method is called it would return a random fortune from the array.
        2. Inject your new dependency into your Coach implementation
        3. Test your application to verify you are getting random fortunes based on your fortunes file.
                Compare your code to the solution. The solution is available here:
        - http://www.luv2code.com/downloads/udemy-spring-hibernate/solution-practice-activities.zip*/
        coach = context.getBean("tennisCoach75", Coach.class);
        System.out.println("75"+coach.getDailyFortune());


        context.close();


    }
}

