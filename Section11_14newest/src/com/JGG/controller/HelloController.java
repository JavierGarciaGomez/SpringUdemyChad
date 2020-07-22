package com.JGG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/home")
    public String homeTest(){
        return "home-page";
    }
}
