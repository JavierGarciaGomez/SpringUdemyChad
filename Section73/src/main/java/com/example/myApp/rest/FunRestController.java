package com.example.myApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//507, 512
@RestController
public class FunRestController {

    //expose "/" that return hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Tome on server is "+ LocalDateTime.now();
    }

    // 512 Expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }
}
