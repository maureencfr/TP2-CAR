package com.commandes.gestionCommandes.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public AccountEntity() {}

    public AccountEntity(String nom, String prenom, String email, String password) {
        this.nom=nom;
        this.prenom=prenom;
        this.password=password;
        this.email=email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
