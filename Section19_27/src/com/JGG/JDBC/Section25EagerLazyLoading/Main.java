package com.JGG.JDBC.Section25EagerLazyLoading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        // 212 Create session factory
        factory = new Configuration().configure("hibernate.cfg24.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).
                        buildSessionFactory();

        int selection;
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

                case 4:
                    deleteWithCascade();
                    break;

                case 5:
                    createCourse();
                    break;

                case 6:
                    retrieveInstructorCourses();
                    break;

                case 7:
                    deleteCourse();
                    break;

                case 9:
                    factory.close();
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
                        "\n2. Delete instructor" +
                        "\n3. Get the instructor detail" +
                        "\n4. Delete with cascade" +
                        "\n5. Create course" +
                        "\n6. Retrieve instructor courses" +
                        "\n7. Delete a course" +
                        "\n9. Exit");
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

        try {

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

        } finally {
            session.close();
        }

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

    //217
    private static void getInstructorDetail() {
        System.out.println("GET INSTRUCTOR DETAIL");

        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());
        session = factory.getCurrentSession();
        //Get instructorDetail by pK
        try {
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail: " + instructorDetail);
            //Get the associate instructor
            System.out.println("Instructor: " + instructorDetail.getInstructor());
            // Commit
            session.getTransaction().commit();

        } catch (NullPointerException ignore) {

        } finally {
            session.close();
        }

    }

    //219Cascade delete
    private static void deleteWithCascade() {
        System.out.println("GET INSTRUCTOR DETAIL");

        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());
        session = factory.getCurrentSession();
        //Get instructorDetail by pK
        try {
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail: " + instructorDetail);
            //Get the associate instructor
            System.out.println("Instructor: " + instructorDetail.getInstructor());
            // Deletion
            session.delete(instructorDetail);
            session.getTransaction().commit();

        } catch (NullPointerException ignore) {

        } finally {
            session.close();
        }
    }

    //229
    private static void createCourse() {

        try {
            System.out.println("CREATE A NEW COURSE");
            System.out.println("Insert the id of the instructor");
            int id = Integer.parseInt(scanner.nextLine());
            session = factory.getCurrentSession();
            //Get instructorDetail by pK
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Instructor retrieved: " + instructor);
            // create the course
            System.out.println("Insert the title");
            String title = scanner.nextLine();
            Course course = new Course(title);
            // Add the course to the instructor
            instructor.addCourse(course);
            session.save(course);

            session.getTransaction().commit();

        } catch (NullPointerException ignore) {

        } finally {
            session.close();
        }
    }

    //230
    private static void retrieveInstructorCourses() {

        try {
            System.out.println("RETRIEVE INSTRUCTOR COURSES");
            System.out.println("Insert the id of the instructor");
            int id = Integer.parseInt(scanner.nextLine());
            session = factory.getCurrentSession();
            //Get instructorDetail by pK
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Instructor retrieved: " + instructor);
            // create the course
            System.out.println(instructor.getCourses());
            session.getTransaction().commit();

        } catch (NullPointerException ignore) {

        } finally {
            session.close();
        }
    }

    //231
    private static void deleteCourse() {

        try {
            System.out.println("DELETE A COURSE");
            System.out.println("Insert the id of the course");
            int id = Integer.parseInt(scanner.nextLine());
            session = factory.getCurrentSession();
            //Get instructorDetail by pK
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            System.out.println("Course retrieved: " + course);
            // Delete the course
            session.delete(course);
            session.getTransaction().commit();

        } catch (NullPointerException ignore) {

        } finally {
            session.close();
        }
    }



}