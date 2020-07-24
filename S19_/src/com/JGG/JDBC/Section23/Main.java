package com.JGG.JDBC.Section23;

import com.JGG.JDBC.Section21exercise.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        // 212 Create session factory
        factory = new Configuration().configure("hibernate.cfg23_uni.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).
                        buildSessionFactory();

        int selection = 0;
        do {
            printOptions();
            selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1:
                    createInstructor();
                    break;

                case 2:
                    deleteInstructor();
                    break;

                case 3:
                    getInstructorDetail();
                    break;

                case 6:
                    retrieveEmployee();
                    break;

                case 7:
                    queryEmployees();
                    break;


                default:
                    break;


            }
        } while (selection != 9);


    }

    private static void printOptions() {
        System.out.println(
                "Escoge una de las siguientes opciones: " +
                        "\n1. Create a new Instructor" +
                        "\n2. Retrieve an instructor with primary key" +
                        "\n3. Get the instructor detail" +
                        "\n4. Delete an object by primary key" +
                        "\n5. Exit");
    }

    //212
    private static void createInstructor() {
        System.out.println("CREATE A NEW INSTRUCTOR");
        System.out.println("Insert the first name");
        String firstName = scanner.nextLine();
        System.out.println("Insert the last name");
        String lastName = scanner.nextLine();
        System.out.println("Insert the email");
        String email = scanner.nextLine();
        System.out.println("Insert the Youtube site");
        String youtube = scanner.nextLine();
        System.out.println("Insert the Hobby");
        String hobby = scanner.nextLine();

        session = factory.getCurrentSession();
        // Create the objects
        Instructor instructor = new Instructor(firstName, lastName, email);
        InstructorDetail instructorDetail = new InstructorDetail(youtube, hobby);

        //Associate the objects
        instructor.setInstructorDetail(instructorDetail);

        //start a transaction
        session.beginTransaction();

        //save the  object. This will also save the details objects because of the CascadeType.All
        System.out.println("Saving instructor " + instructor);
        session.save(instructor);

        //commit transaction
        session.getTransaction().commit();
        System.out.println("Saved correctly: " + instructor);

    }

    //214
    private static void deleteInstructor() {

        System.out.println("DELETE AN INSTRUCTOR");
        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());
        session = factory.getCurrentSession();
        session.beginTransaction();
        //Get instructor by pK
        Instructor instructor = session.get(Instructor.class, id);
        System.out.println("Found instructor: " + instructor);
        //Delete de instructor
        if (instructor != null) {
            System.out.println("Deleting " + instructor);
            session.delete(instructor);
        }
        // Commit query
        session.getTransaction().commit();
        System.out.println("Deleted correctly");
    }

    private static void getInstructorDetail() {
        System.out.println("GET INSTRUCTOR DETAIL");

        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());
        session = factory.getCurrentSession();
        //Get instructorDetail by pK
        try{
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail: "+instructorDetail);
            //Get the associate instructor
            System.out.println("Instructor: "+instructorDetail.getInstructor());
            // Commit

        } catch (NullPointerException ignore){

        }finally {
            session.close();
        }

    }


    private static void retrieveEmployee() {
        System.out.println("RETRIEVE A EMPLOYEE");

        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());

        session = factory.getCurrentSession();
        //start a transaction
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        System.out.println("Retrieved correctly: " + employee);
        session.getTransaction().commit();
    }

    private static void queryEmployees() {
        System.out.println("QUERY EMPLOYEES");

        System.out.println("Insert the company name");
        String company = scanner.nextLine();

        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee where company='" + company + "'").getResultList();
        System.out.println("Retrieved correctly: " + employees);
        session.getTransaction().commit();
    }


}
