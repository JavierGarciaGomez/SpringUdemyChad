package com.JGG.JDBC.Section21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    //198
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        
        try{
            int studentId = 5;
            session.beginTransaction();
            System.out.println("\nGetting student with id: "+studentId);
            Student student=session.get(Student.class, studentId);
            System.out.println("Updating student");
            student.setFirstName("Scooby");
            System.out.println("Get complete: "+student);

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
