package com.JGG.springdemo.rest;

import com.JGG.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//465, 468
@RestController
@RequestMapping("/api")
public class StudentRestController {

    //468
    private List<Student> students;

    //468 Definie @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // 469. define endpoint for "/student{studentId}" - return just one student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return students.get(studentId);
    }
}
