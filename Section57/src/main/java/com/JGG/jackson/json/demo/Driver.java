package com.JGG.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//451, 452
public class Driver {
    public static void main(String[] args) {
        //451
        System.out.println("***********451***************");
        try {
            // Create object mapper
            ObjectMapper mapper = new ObjectMapper();
            // read JSON file and map/conver to Java POJO: data/sample-lite.json
            Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
            // print
            System.out.println("First name "+student.getFirstName());
            System.out.println("Last name "+student.getLastName());


        } catch (IOException e) {
            e.printStackTrace();
        }
        //452
        System.out.println("***********452***************");
        try {
            // Create object mapper
            ObjectMapper mapper = new ObjectMapper();
            // read JSON file and map/conver to Java POJO: data/sample-lite.json
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
            // print
            System.out.println("First name "+student.getFirstName());
            System.out.println("Last name "+student.getLastName());
            System.out.println("Printing student "+student);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
