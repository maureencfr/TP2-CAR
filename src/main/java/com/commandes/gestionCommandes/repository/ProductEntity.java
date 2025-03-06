package com.commandes.gestionCommandes.repository;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRIX")
    private float prix;

    @Column(name = "QUANTITE")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "commandId")
    private CommandEntity command;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    public ProductEntity() {}

    public ProductEntity(String nom, float prix, int quantite, CommandEntity command) {
        this.nom=nom;
        this.prix=prix;
        this.command=command;
        this.quantite=quantite;
    }

    public Long getId(){ return productId;}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
