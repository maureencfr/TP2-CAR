package com.commandes.gestionCommandes.service;

import com.commandes.gestionCommandes.kafka.KafkaProducer;
import com.commandes.gestionCommandes.repository.AccountEntity;
import com.commandes.gestionCommandes.repository.CommandEntity;
import com.commandes.gestionCommandes.repository.ProductEntity;
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

    @Autowired
    private KafkaProducer kafkaProducer;

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

    public void envoyerCommandeKafka(Long id) {
        CommandEntity command = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        StringBuilder message = new StringBuilder("Commande:" + command.getId() + ";");

        for (ProductEntity product : command.getProducts()) {
            message.append(product.getNom()).append(",").append(product.getQuantite()).append(";");
        }

        kafkaProducer.produce(message.toString());
    }
}
