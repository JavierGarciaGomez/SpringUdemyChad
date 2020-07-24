package com.JGG.JDBC.Section21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    //191
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure("hibernate21_22.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();
        
        try{
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Cirilo", "Cardenas", "cirilo@gmail.com");
            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving student");
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE");

            // 191 new code
            // find out the student's id: primary key
            System.out.println("id "+tempStudent.getId());
            // get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve the student based on the id
            System.out.println("\nGetting student with id: "+tempStudent.getId());
            Student student=session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: "+student);
            //commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
