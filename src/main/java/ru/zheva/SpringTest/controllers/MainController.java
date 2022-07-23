package ru.zheva.SpringTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vladimir
 */
@Controller
public class MainController {
    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }    
}
