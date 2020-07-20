package com.JGG.SpringCourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//L 44 Created
public class MyAppS6 {
    public static void main(String[] args) {
        // Load the spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/JGG/SpringCourse/beanScope.xml");
        // Retrieve a bean from spring container
        // scope
        Coach coach1 = context.getBean("myCoachSingleton", Coach.class);
        Coach coach2 = context.getBean("myCoachSingleton", Coach.class);
        if (coach1.equals(coach2)) System.out.println("They are the same instance");
        else System.out.println("They are NOT the same instance");
        // Prototype
        coach1 = context.getBean("myCoachPrototype", Coach.class);
        coach2 = context.getBean("myCoachPrototype", Coach.class);
        if (coach1.equals(coach2)) System.out.println("They are the same instance");
        else System.out.println("They are NOT the same instance");

        // 48
        coach1 = context.getBean("myCoachInitDestroy", Coach.class);
        System.out.println(coach1.toString());
        context.close();

    }
}

