package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.AccountRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisconnectService {

    public String disconnect(){
        return "login";
    }
}
