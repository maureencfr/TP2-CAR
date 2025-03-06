package com.commandes.gestionCommandes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    public List<ProductEntity> findByCommandId(Long commandId);
}
