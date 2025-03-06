package com.commandes.gestionCommandes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepository extends CrudRepository<CommandEntity, Long> {
    public List<CommandEntity> findByClientId(Long clientId);
}
