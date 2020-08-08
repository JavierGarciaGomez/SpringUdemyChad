package com.example.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//507, 512, 518
@RestController
public class FunRestController {

    //expose "/" that return hello world
    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Tome on server is " + LocalDateTime.now();
    }

    // 512 Expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    //518 Inject properties from application.properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //518 expose new endpoint for teaminfo
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "coach: "+coachName+", team name: "+teamName;
    }
}
