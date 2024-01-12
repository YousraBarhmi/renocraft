package com.jeeproject.renocraft.web.controller;


import com.jeeproject.renocraft.entity.User;
import com.jeeproject.renocraft.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class RenoCraftController {
    @Autowired
    private UserService service;
    @GetMapping ("/")
    public String welcomePage(){
        return "index";
    }

    @GetMapping ("/signup")
    public String register(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "signup";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (service.usernameExists(user.getUsername())) {
            model.addAttribute("usernameExists", true);
            return "signup";
        }
        service.registerUser(user);
        return "signin";
    }


    @GetMapping ("/signin")
    public ModelAndView signin()
    {
        ModelAndView mav = new ModelAndView("signin");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute("user") User user, HttpSession session ) {

        User oauthUser = service.signin(user.getUsername(), user.getPassword());

        if (Objects.nonNull(oauthUser)) {
            // Set the user in the session
            session.setAttribute("user", oauthUser);

            // Assuming you want to redirect to the home page upon successful sign-in
            return "redirect:/";
        } else {
            // Redirect back to the sign-in page with an error parameter
            return "redirect:/error";
        }
    }

}
