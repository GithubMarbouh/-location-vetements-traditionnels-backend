package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="catalogue")
public class Catalogue extends AbstractEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_catalogue;
    private String nom ;
    private String description ;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogue" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Produit> produits;

    public Catalogue(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Catalogue() {}

//    public Integer getId_catalogue() {
//        return id_catalogue;
//    }
//
//    public void setId_catalogue(Integer id_catalogue) {
//        this.id_catalogue = id_catalogue;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
