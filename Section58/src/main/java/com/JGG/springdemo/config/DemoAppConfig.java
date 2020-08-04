package com.JGG.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//460
@Configuration
@EnableWebMvc
@ComponentScan("com.JGG.springdemo")
public class DemoAppConfig {
}
