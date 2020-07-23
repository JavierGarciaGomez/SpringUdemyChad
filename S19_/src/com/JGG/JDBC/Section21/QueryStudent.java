package com.JGG.JDBC.Section21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    //194
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        
        try{
            //start a transaction
            session.beginTransaction();

            System.out.println("Query all students");
            List<Student> studentList=session.createQuery("from Student ").getResultList();
            displayStudents(studentList);

            System.out.println("Query students lastname=Garcia");
            studentList=session.createQuery("from Student Where lastName='Garcia'").getResultList();
            displayStudents(studentList);

            System.out.println("Query students lastname=Garcia or first name Cirilo");
            studentList=session.createQuery("from Student Where lastName='Garcia' or firstName='Cirilo'").getResultList();
            //Display students
            displayStudents(studentList);

            System.out.println("Query students like er");
            studentList=session.createQuery("from Student Where firstName Like '%er%'").getResultList();
            //Display students
            displayStudents(studentList);



            //commit transaction
            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
