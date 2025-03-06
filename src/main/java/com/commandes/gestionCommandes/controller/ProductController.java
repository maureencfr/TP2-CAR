package com.commandes.gestionCommandes.controller;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.CommandEntity;
import com.commandes.gestionCommandes.repository.ProductEntity;
import com.commandes.gestionCommandes.service.CommandService;
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
public class ProductController {
    @Autowired
    private CommandService service;

    @Autowired
    private ProductService productService;

    @GetMapping("/store/user/{id}")
    public String getCommand(@PathVariable Long id, Model model) {
        List<ProductEntity> products = productService.getProducts(id);
        model.addAttribute("products", products);
        model.addAttribute("command", service.getCommandById(id));
        return "editCommand";
    }

    @PostMapping("/store/user/{id}/product")
    public RedirectView addArticle(@PathVariable Long id, @RequestParam String productName, @RequestParam int quantite, @RequestParam float prix) {
        productService.addProduct(productName, prix, quantite, id);
        return new RedirectView("/store/user/"+id);
    }

    @PostMapping("/store/user/{id}/product/{productId}")
    public RedirectView deleteArticle(@PathVariable Long id, @PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new RedirectView("/store/user/"+id);
    }

}

