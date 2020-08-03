package com.JGG.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//396
@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showHome(){
        return "fancy-login";
    }

    // 421 add request mapping ofr /access denied
    @GetMapping("/accessDenied")
    public String showAccessDenied(){
        return "access-denied";
    }

}
