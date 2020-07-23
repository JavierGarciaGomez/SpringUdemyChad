package com.JGG.JDBC.Section21exercise;

import com.JGG.JDBC.Section21.Student;
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
        // Create session factory
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        int selection = 0;
        do {
            printOptions();
            selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 5:
                    createEmployee();
                    break;

                case 6:
                    retrieveEmployee();
                    break;

                case 7:
                    queryEmployees();
                    break;
                    
                case 8:
                    deleteEmployee();
                    break;
                    
                default:
                    break;
                    

            }
        } while (selection != 9);


    }



    private static void printOptions() {
        System.out.println(
                "Escoge una de las siguientes opciones: " +
                        "\n5. Create a new employee" +
                        "\n6. Retrieve an employee with primary key" +
                        "\n7. Query objects to find employees for a given company" +
                        "\n8. Delete an object by primary key" +
                        "\n9. Exit");
    }

    private static void createEmployee() {
        System.out.println("CREATE A NEW EMPLOYEE");

        System.out.println("Insert the first name");
        String firstName = scanner.nextLine();
        System.out.println("Insert the last name");
        String lastName = scanner.nextLine();
        System.out.println("Insert the company name");
        String company = scanner.nextLine();

        session = factory.getCurrentSession();
        Employee employee = new Employee(firstName, lastName, company);
        //start a transaction
        session.beginTransaction();
        //save the  object
        session.save(employee);
        //commit transaction
        session.getTransaction().commit();
        System.out.println("Saved correctly: " + employee);

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
        List<Employee> employees=session.createQuery("from Employee where company='"+company+"'").getResultList();
        System.out.println("Retrieved correctly: " + employees);
        session.getTransaction().commit();
    }

    private static void deleteEmployee() {

        System.out.println("DELETE A EMPLOYEE");

        System.out.println("Insert the id");
        int id = Integer.parseInt(scanner.nextLine());

        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Employee where id="+id).executeUpdate();
        session.getTransaction().commit();
        System.out.println("Deleted correctly");
    }


}
