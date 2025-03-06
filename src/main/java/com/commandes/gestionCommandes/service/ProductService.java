package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    @Autowired
    private CommandRepository commandRepository;

    public List<ProductEntity> getProducts(Long commandId){
        return repo.findByCommandId(commandId);
    }

    public void addProduct(String nom,float prix, int quantite, Long commandId) {
        CommandEntity commande = commandRepository.findById(commandId).orElse(null);
        if (commande != null) {
            ProductEntity product = new ProductEntity(nom,prix, quantite, commande);
            repo.save(product);
        }
    }

    public void deleteProduct(Long id) {
        ProductEntity product = repo.findById(id).orElse(null);
        if (product != null) {
            repo.delete(product);
        }
    }

}
