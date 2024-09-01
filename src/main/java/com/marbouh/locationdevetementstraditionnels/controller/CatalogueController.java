package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Catalogue;
import com.marbouh.locationdevetementstraditionnels.services.impl.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @PostMapping(value = {"/ajouterCatalogue"})
    public Catalogue ajouterCatalogue(@RequestBody Catalogue catalogue) {
        return catalogueService.ajouterCatalogue(catalogue);
    }

    @GetMapping({"/getAllCatalogues"})
    public Iterable<Catalogue> getAllCatalogues() {
        return catalogueService.getAllCatalogues();
    }

    @PostMapping({"/ajouterProduitToCatalogue{id_catalogue}/{id_produit}"})
    public void ajouterProduitToCatalogue(@PathVariable("id_catalogue") Integer id_catalogue, @PathVariable("id_produit") Integer id_produit) {
        catalogueService.ajouterProduitToCatalogue(id_catalogue, id_produit);
    }

    @GetMapping({"/getAllProduitsFromCatalogue{id_catalogue}"})
    public List getAllProduitsFromCatalogue(@PathVariable("id_catalogue") Integer id_catalogue) {
        return catalogueService.getAllProduitsFromCatalogue(id_catalogue);
    }
}
