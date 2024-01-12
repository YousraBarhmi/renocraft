package com.jeeproject.renocraft.web.controller;

import com.jeeproject.renocraft.entity.Contact;
import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.entity.Service;
import com.jeeproject.renocraft.service.ContactService;
import com.jeeproject.renocraft.service.EmployeurService;
import com.jeeproject.renocraft.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RenoCraftController {
    private final ContactService contactService;
    private final EmployeurService employeurService;
    private final ServiceService serviceService;
    private Long actualServiceId = 1L;

    public RenoCraftController(ContactService contactService,
                               EmployeurService employeurService,
                               ServiceService serviceService) {
        this.contactService = contactService;
        this.employeurService = employeurService;
        this.serviceService = serviceService;
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

@GetMapping("/service")
public String getEmployeesByService(
        @RequestParam(required = false) Long serviceId,
        @RequestParam(required = false) String city,
        Model model) {
    actualServiceId = (serviceId != null) ? serviceId : actualServiceId;
    List<Employeur> employeurs;

    if (city == null) {
        employeurs = employeurService.getEmployeurByService(actualServiceId);
    } else {
        employeurs = employeurService.getEmployeurByServiceCity(actualServiceId, city);
    }

    model.addAttribute("employeurs", employeurs);
    model.addAttribute("actualServiceId", actualServiceId); // Adding actualServiceId to the model
    return "service";
}






}
