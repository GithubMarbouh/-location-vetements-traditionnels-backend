package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Table(name="produit")
public class Produit extends AbstractEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_produit;
    private String nom ;
    private String description ;
    private String categorie ;
    private String prixLocation;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="image_produit", joinColumns = {@JoinColumn (name="id_produit")} , inverseJoinColumns = {@JoinColumn ( name = "id_image")})
    private Set<Image> Images;
    private int id_boutique ;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_catalogue")
    @JsonIgnore
    private Catalogue catalogue;
    @ManyToMany(mappedBy = "produits")
    @JsonIgnore
    private Set<CreneauDisponibilite> creneauDisponibilites;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "produit")
    private List<Location> locations;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "produit")
    private List<Reservation> reservation;


    public Produit() {}

    public Produit(String nom, String description, String categorie, String prixLocation) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.prixLocation = prixLocation;
    }

//    public int getId_produit() {
//        return id_produit;
//    }
//
//    public void setId_produit(int id_produit) {
//        this.id_produit = id_produit;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(String prixLocation) {
        this.prixLocation = prixLocation;
    }

    public int getId_boutique() {
        return id_boutique;
    }

    public void setId_boutique(int id_boutique) {
        this.id_boutique = id_boutique;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Set<Image> getImages() {
        return Images;
    }

    public void setImages(Set<Image> images) {
        Images = images;
    }

    public Set<CreneauDisponibilite> getCreneauDisponibilites() {
        return creneauDisponibilites;
    }

    public void setCreneauDisponibilites(Set<CreneauDisponibilite> creneauDisponibilites) {
        this.creneauDisponibilites = creneauDisponibilites;
    }
}
