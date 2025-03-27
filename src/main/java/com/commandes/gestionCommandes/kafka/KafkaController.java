package com.commandes.gestionCommandes.kafka;

import com.commandes.gestionCommandes.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    @Autowired
    private CommandService service;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/store/user/{id}/send")
    public RedirectView produceMessage(@PathVariable Long id) {
        service.envoyerCommandeKafka(id);
        return new RedirectView("/store/user");
    }
}
