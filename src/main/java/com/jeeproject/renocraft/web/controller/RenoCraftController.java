package com.jeeproject.renocraft.web.controller;



import com.jeeproject.renocraft.entity.*;
import com.jeeproject.renocraft.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;


import com.jeeproject.renocraft.entity.User;
import com.jeeproject.renocraft.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class RenoCraftController {
    @Autowired
    private UserService service;
    private final ContactService contactService;
    private final EmployeurService employeurService;
    private final ServiceService serviceService;
    private final UserService userService;
    private final CommandeService commandeService;
    private final PackService packService;
    private Long actualServiceId = 1L;

    public RenoCraftController(ContactService contactService,
                               EmployeurService employeurService,
                               ServiceService serviceService,
                               UserService userService,CommandeService commandeService,PackService packService) {
        this.contactService = contactService;
        this.employeurService = employeurService;
        this.serviceService = serviceService;
        this.userService = userService;
        this.commandeService=commandeService;
        this.packService=packService;
    }


    //mapping
    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }


    @GetMapping("/signup")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
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

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }

    @GetMapping("/packs")
    public String packsPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {
            return "pack";
        } else {
            return "redirect:/signin";
        }
    }

<<<<<<< HEAD
        @GetMapping ("/cart")
        public String cartPage(HttpServletRequest request, Model model){
            HttpSession session = request.getSession();
            if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {
                String user = (String) session.getAttribute("userName");
                Optional<User> cart = userService.getUser(user);
                model.addAttribute("cart", cart);
                return "cart";
            } else {
                return "redirect:/signin";
            }
        }

    @PostMapping ("/cart")
    public String processCommande(@RequestParam("dateCommande") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateCommande,
                                  @RequestParam("heureCommande") @DateTimeFormat(pattern = "HH:mm") Date heureCommande,
                                  @RequestParam("packIds") List<Long> packIds,
                                  @SessionAttribute("userName") String username){
        Optional<User> optionalUser = userService.getUser(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();


            Commande commande = new Commande();
            commande.setUser(user);
            commande.setDateCommande(dateCommande);
            commande.setHeureCommande(heureCommande);


            List<Pack> packs = packService.findPacksByIds(packIds);
            commande.setPacks(packs);


            commandeService.addCommande(commande);


            return "redirect:/cart";
        }
        else{
            return "redirect:/error";
        }
    }





=======
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/signin";
    }

    @GetMapping("/cart")
    public String cartPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {
            return "cart";
        } else {
            return "redirect:/signin";
        }
    }
>>>>>>> 1abe2a5944ff990979ae0a078f3e91a9865712e6


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
    public String getEmployeesByService(HttpServletRequest request,
                                        @RequestParam(required = false) Long serviceId,
                                        @RequestParam(required = false) String city,
                                        Model model) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {
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
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/home")
    public String homeAfterConn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {

            return "home";
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/profil")
    public String getProfil(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")) {
            String user = (String) session.getAttribute("userName");
            Optional<User> profil = userService.getUser(user);
            model.addAttribute("profil", profil);
            return "profil";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/profil")
    public String editProfile(@ModelAttribute("profil") User updatedUser) {
        // Perform the user profile update
        boolean editSuccessful = userService.editUser(updatedUser);

        if (editSuccessful) {
            System.out.println("yes");
            // Redirect to the profile page with a success message
            return "redirect:/profil?success";
        } else {
            // Redirect to the profile page with an error message
            System.out.println("no");
            return "redirect:/profil?error";
        }
    }


    @GetMapping("/signin")
    public ModelAndView signin() {
        ModelAndView mav = new ModelAndView("signin");
        mav.addObject("user", new User());
        return mav;
    }


    @PostMapping("/signin")
    public String signin(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User oauthUser = service.signin(user.getUsername(), user.getPassword());
        System.out.println(oauthUser);
        if (session != null && oauthUser != null) {
            session.setAttribute("connexion", true);
            String userName = oauthUser.getUsername();
            session.setAttribute("userName", userName);
            if (userName.equals("admin")) {
                return "redirect:/dashHome";
            } else {
                return "redirect:/home";
            }
        } else {
            return "redirect:/signin-error";
        }
    }

    @GetMapping("/dashHome")
    public String getDashHome(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("userName");
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")&& user.equals("admin")) {
            return "Dash/dashHome";
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashClient")
    public String getDashClients(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("userName");
        if (session != null && session.getAttribute("connexion") != null && (boolean) session.getAttribute("connexion")&& user.equals("admin")) {
            return "Dash/dashClient";
        } else {
            return "redirect:/signin";
        }
    }
}