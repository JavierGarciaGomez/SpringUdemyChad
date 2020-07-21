package com.JGG.SpringCourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.JGG.SpringCourse")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // Define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for our swim coach and inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService()); // calling the previous methd
    }

    //92


}
