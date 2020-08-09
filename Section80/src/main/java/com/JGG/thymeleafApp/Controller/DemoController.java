package com.JGG.thymeleafApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//541
@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

}
