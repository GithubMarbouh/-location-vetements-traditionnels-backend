package com.marbouh.locationdevetementstraditionnels.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
    private Instant date;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Produit produit;
    private boolean accepted;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Utilisateur client;
    @ManyToOne(cascade = CascadeType.ALL)
    private CreneauEssayage creneauEssayage;


    public Reservation(Instant date, Produit produit, Utilisateur client, boolean accepted) {
        this.date = date;
        this.produit=produit;
        this.accepted = accepted;
        this.client = client;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
