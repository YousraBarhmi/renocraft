package com.jeeproject.renocraft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RenoCraftController {
    @GetMapping ("/")
    public String welcomePage(){
        return "index";
    }


    @GetMapping ("/signup")
    public String signUp(){
        return "signup";
    }

    @GetMapping ("/signin")
    public String signIn(){
        return "signin";
    }

}
