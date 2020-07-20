package com.JGG.SpringCourse;

import org.springframework.http.converter.json.GsonBuilderUtils;

//35, 37
public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String email;
    private String team;
    private String refereeName; //41


    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    public CricketCoach() {
        System.out.println("Im inside the constructor");
    }

    @Override
    public String getDailyWorkout() {
        return this.getClass().getSimpleName()+" Practice fast bowling for 15 minutes";
    }

    @Override
    public String getPresentation() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Im inside the setter method");
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "CricketCoach{" +
                "fortuneService=" + fortuneService +
                ", email='" + email + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    public String getRefereeName() {
        return refereeName;
    }

    public CricketCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }



}
