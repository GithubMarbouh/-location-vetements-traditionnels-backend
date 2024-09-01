package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.repository.CreneauEssayageRepository;
import com.marbouh.locationdevetementstraditionnels.model.CreneauDisponibilite;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauDisponibiliteDAO;
import com.marbouh.locationdevetementstraditionnels.services.impl.CreneauDisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreneauDisponibiliteController {

    @Autowired
    private CreneauDisponibiliteService creneauDisponibiliteService;
    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;

    @PostMapping("/ajouterCreneauProduit/{id_produit}/{id_creneau}")
    public CreneauDisponibilite ajouterCreneauProduit(@PathVariable Integer id_creneau, @PathVariable Integer id_produit) {
        return creneauDisponibiliteService.ajouterCreneauProduit(creneauDisponibiliteDAO.findById(id_creneau).get(), id_produit);
    }

    @PostMapping("/ajouterCreneau")
    public CreneauDisponibilite ajouterCreneau(@RequestBody CreneauDisponibilite creneauDisponibilite) {
        return creneauDisponibiliteService.ajouterCreneau(creneauDisponibilite);
    }
}
