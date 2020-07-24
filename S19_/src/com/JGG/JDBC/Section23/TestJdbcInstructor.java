package com.JGG.JDBC.Section23;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcInstructor {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
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
