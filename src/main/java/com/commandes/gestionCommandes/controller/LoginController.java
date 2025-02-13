package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.service.FormularLoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    @Autowired
    private FormularLoginService service;

    @GetMapping("/store/home")
    public String displayHomePage(){
        return "login";
    }

    @PostMapping("/store/user/creation")
    public String createAndConnectUser(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String password, HttpSession session) {

        return service.create(nom, prenom, email, password, session);
    }

    @PostMapping("/store/user/login")
    public String connectUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        return service.search(email, password, session);
    }
}
