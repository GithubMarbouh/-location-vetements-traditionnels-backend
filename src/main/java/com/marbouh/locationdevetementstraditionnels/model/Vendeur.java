package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "vendeur")
@DiscriminatorValue("VENDEUR")
public class Vendeur extends Utilisateur{
    private String identifiant;
    @OneToOne(mappedBy = "vendeur")
    private Boutique boutique;
    public void ajouterBoutique(Boutique boutque ) {

    }
    public void supprimerBoutique(Boutique boutique) {
    }
}
