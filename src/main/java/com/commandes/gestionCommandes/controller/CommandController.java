package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.CommandEntity;
import com.commandes.gestionCommandes.service.CommandService;
import com.commandes.gestionCommandes.service.FormularLoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CommandController {
    @Autowired
    private CommandService service;

    @GetMapping("/store/user")
    public String getCommands(HttpSession session, org.springframework.ui.Model model) {
        AccountEntity user = (AccountEntity) session.getAttribute("utilisateur");
        if (user != null) {
            Long clientId = user.getId();
            List<CommandEntity> commands = service.getCommands(clientId);
            model.addAttribute("commands", commands);
            session.setAttribute("commands", service.getCommands(clientId));
        }
        return "user";
    }


    @PostMapping("/store/user")
    public RedirectView addCommand(@RequestParam String commandName, HttpSession session){
        service.createCommand(commandName, session);
        return new RedirectView("/store/user");
    }
}

