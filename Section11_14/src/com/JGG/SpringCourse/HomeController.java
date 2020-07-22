package com.JGG.SpringCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//105
// 1. Create controller class
@Controller
public class HomeController {

    // 2. Define controller method and 3. request mapping
    @RequestMapping("/")
    public String showPage(){
        // 4. Return view name
        return "mainmenu";

    }
}
