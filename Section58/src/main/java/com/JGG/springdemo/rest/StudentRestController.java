package com.JGG.springdemo.rest;

import com.JGG.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // 469. define endpoint for "/student{studentId}" - return just one student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list
        // 473 check the studentId against the list
        if (studentId >= students.size() || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return students.get(studentId);
    }

/* Removed in 478, and pasted in StudentRestExceptionHandler as a Global Exception Handler
   // 474. Add an exceptionhandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException studentNotFoundException){
        //474 create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        // return responseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
    //476 Add another exceptionHandler for other exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception e){
        //474 create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value()); // Bad request
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        // return responseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }*/

}
