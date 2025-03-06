package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.CommandEntity;
import com.commandes.gestionCommandes.repository.ProductEntity;
import com.commandes.gestionCommandes.service.CommandService;
import com.commandes.gestionCommandes.service.FormularLoginService;
import com.commandes.gestionCommandes.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CommandController {
    @Autowired
    private CommandService service;

    @Autowired
    private ProductService productService;

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

    @PostMapping("/store/user/{id}")
    public String editCommand(@PathVariable Long id, org.springframework.ui.Model model) {
        CommandEntity command = service.getCommandById(id);
        model.addAttribute("command", command);
        List<ProductEntity> products = productService.getProducts(id);
        model.addAttribute("products", products);
        return "editCommand";
    }

    @PostMapping("/store/user/{id}/display")
    public String displayCommand(@PathVariable Long id, Model model) {
        List<ProductEntity> products = productService.getProducts(id);
        model.addAttribute("products", products);
        model.addAttribute("command", service.getCommandById(id));
        System.out.println(service.getCommandById(id).getNom());
        return "displayCommand";
    }

}

