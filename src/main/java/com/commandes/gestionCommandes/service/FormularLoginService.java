package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.AccountRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularLoginService {
    @Autowired
    private AccountRepositoryService repo;

    public String create(String nom, String prenom, String email, String password){
        if (repo.findByEmailAndPassword(email, password)!= null){
            return "userCreationError";
        }
            var newUser = new AccountEntity(nom, prenom,email,password);
            repo.save(newUser);
            return "user";
    }

    public String search(String email, String password){
        if (repo.findByEmailAndPassword(email, password)!= null){
            return "user";
        }
        return "userLoginError";
    }
}
