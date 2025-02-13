package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.service.FormularLoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private FormularLoginService service;

    @PostMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("/store/home");
    }
}
