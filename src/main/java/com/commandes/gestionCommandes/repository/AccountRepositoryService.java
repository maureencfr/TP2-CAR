package com.commandes.gestionCommandes.repository;

import org.springframework.stereotype.Service;

@Service
public class AccountRepositoryService {

    private final AccountRepository repo;

    public AccountRepositoryService(AccountRepository repo) {
        this.repo = repo;
    }

    public AccountEntity findByEmailAndPassword(String email, String password){
        return this.repo.findByEmailAndPassword(email, password);
    }

    public void save(AccountEntity entity){
        this.repo.save(entity);
    }
}
