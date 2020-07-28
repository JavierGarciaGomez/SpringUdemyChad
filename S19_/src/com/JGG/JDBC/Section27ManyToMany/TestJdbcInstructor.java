package com.JGG.JDBC.Section27ManyToMany;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcInstructor {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting to database: "+jdbcURL);
            Connection connection= DriverManager.getConnection(jdbcURL, user, pass);
            System.out.println("Success");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
