package com.JGG.JDBC.Section21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    //199
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate21_22.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        
        try{
            int studentId = 5;
            session.beginTransaction();
            System.out.println("\nGetting student with id: "+studentId);
            Student student=session.get(Student.class, studentId);
            System.out.println("Deleting student");
            System.out.println("Get complete: "+student);
            session.delete(student);

            /*
            * Another way:
            * session.createQuery("delete from Employee where id=2").executeUpdate();
            * */


            //commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
