package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.AccountRepositoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularLoginService {
    @Autowired
    private AccountRepositoryService repo;

    @Autowired
    private CommandService commandService;

    public String create(String nom, String prenom, String email, String password, HttpSession session) {
        if (repo.findByEmailAndPassword(email, password)!= null){
            return "userCreationError";
        }
            var newUser = new AccountEntity(nom, prenom,email,password);
            session.setAttribute("utilisateur", newUser);
            repo.save(newUser);
            return "/user";
    }

    public String search(String email, String password, HttpSession session) {
        AccountEntity user = repo.findByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("utilisateur", user);
            session.setAttribute("commands", commandService.getCommands(user.getId()));
            return "redirect:/store/user";
        }
        return "userLoginError";
    }

}
