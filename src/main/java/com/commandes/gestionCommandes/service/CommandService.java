package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.CommandEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commandes.gestionCommandes.repository.CommandRepository;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepository repo;

    public List<CommandEntity> getCommands(Long clientId){
        return repo.findByClientId(clientId);
    }

    public String createCommand(String commandName, HttpSession session){
        CommandEntity entity= new CommandEntity(commandName, LocalDate.now(),(AccountEntity) session.getAttribute("utilisateur"));
        repo.save(entity);
        return "user";
    }

    public CommandEntity getCommandById(Long id){
        return repo.findById(id).orElse(null);
    }
}
