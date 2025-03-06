package com.commandes.gestionCommandes.repository;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "COMMAND")
public class CommandEntity {

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity client;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandId;

    public CommandEntity() {}

    public CommandEntity(String nom, LocalDate date, AccountEntity client) {
        this.nom=nom;
        this.date=date;
        this.client=client;
    }

    public Long getId(){ return commandId;}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
