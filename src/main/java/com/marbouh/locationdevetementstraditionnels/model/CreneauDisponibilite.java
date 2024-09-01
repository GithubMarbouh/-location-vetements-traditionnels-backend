package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="creneaudisp")
public class CreneauDisponibilite extends AbstractEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_creneauDispo;
    private Date dateDebut;
    private Date dateFin;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
            @JoinTable(name="produit_creneau", joinColumns = {@JoinColumn (name="id_creneauDispo")} , inverseJoinColumns = {@JoinColumn ( name = "id_produit")})
    @JsonIgnore
    private Set<Produit> produits = new HashSet<>();

    public CreneauDisponibilite(Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public CreneauDisponibilite() {
    }

//    public Integer getId_creneauDispo() {
//        return id_creneauDispo;
//    }
//
//    public void setId_creneauDispo(Integer id_creneauDispo) {
//        this.id_creneauDispo = id_creneauDispo;
//    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}
