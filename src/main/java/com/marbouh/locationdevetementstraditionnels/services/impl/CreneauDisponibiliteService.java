package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.repository.CreneauDisponibiliteDAO;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitDAO;
import com.marbouh.locationdevetementstraditionnels.model.CreneauDisponibilite;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreneauDisponibiliteService {
//creneaudiaponibilite
    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;
    @Autowired
    private ProduitDAO produitDAO;

    public CreneauDisponibilite ajouterCreneauProduit(CreneauDisponibilite creneauDisponibilite, Integer id_produit){
        Produit produit = produitDAO.findById(id_produit).get();
        creneauDisponibilite.getProduits().add(produit);
        return creneauDisponibiliteDAO.save(creneauDisponibilite);
    }

    public CreneauDisponibilite ajouterCreneau(CreneauDisponibilite creneauDisponibilite){
        return creneauDisponibiliteDAO.save(creneauDisponibilite);
    }


}
