package com.jeeproject.renocraft.web.controller;

import com.jeeproject.renocraft.entity.Contact;
import com.jeeproject.renocraft.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class RenoCraftController {
    private final ContactService contactService;

    //injection de dépendence
    public RenoCraftController(ContactService contactService) {
        this.contactService = contactService;
    }


    //mapping
    @GetMapping ("/")
    public String welcomePage(){
        return "index";
    }


    @GetMapping ("/signup")
    public String register(){
        return "signup";
    }

    @GetMapping ("/signin")
    public String signIn(){
        return "signin";
    }
    @GetMapping ("/success")
    public String successPage(){
        return "success";
    }

    @GetMapping ("/packs")
    public String packsPage(){
        return "pack";
    }


    //controle service
    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "fragments/contact";
    }

    @PostMapping("/contact")
    public String processContactForm(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact);
        return "redirect:/success";
    }

}
