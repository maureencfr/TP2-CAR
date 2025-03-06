package com.commandes.gestionCommandes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    public AccountEntity findByEmailAndPassword(String email, String password);
}
