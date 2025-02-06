package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.service.FormularLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @PostMapping("/store/login")
    public String displayUserPage(){
        return "user";
    }
}
