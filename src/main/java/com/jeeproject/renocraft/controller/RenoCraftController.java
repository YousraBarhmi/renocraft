package com.jeeproject.renocraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RenoCraftController {
    @GetMapping ("/")
    public String welcomePage(){
        return "index";
    }


}
