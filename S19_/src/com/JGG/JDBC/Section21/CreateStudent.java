package com.JGG.JDBC.Section21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    //187
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();
        
        try{
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Javier", "Garcia", "javieron.garcia@gmail.com");
            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving student");
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            factory.close();
        }
    }
}
