package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.service.DisconnectService;
import com.commandes.gestionCommandes.service.FormularLoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private DisconnectService service;

    @PostMapping("/store/home")
    public String displayHomePageAfterDisconnect(){
        return "login";
    }

    @GetMapping("/store/home")
    public void disconnect(HttpSession session, @PathVariable String id ) {
        AccountEntity userLogin = (AccountEntity) session.getAttribute("id");
        if( userLogin == null ) {
            userLogin = service.findById(id);
            session.setAttribute("id", userLogin);
        }
        userLogin.ajouter(id);
    }
}
