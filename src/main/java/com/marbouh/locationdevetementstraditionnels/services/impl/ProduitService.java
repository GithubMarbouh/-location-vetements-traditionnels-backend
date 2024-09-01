package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.CreneauDisponibilite;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauDisponibiliteDAO;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitDAO;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;
    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;
    @Autowired
    private ProduitRepository produitRepository;

    public Produit ajouterProduit(Produit produit){
        produit.setCreationDate(Instant.now());
        return produitDAO.save(produit);
    }
    public List<Produit> getAllProduits() {
        return (List<Produit>) produitDAO.findAll();
    }
    public void supprimerProduit(Integer id_produit) {
        produitDAO.deleteById(id_produit);
    }
    public Produit updateProduit(Produit produit) {
        return produitRepository.saveAndFlush(produit);
    }
    public Set<Produit> getProduitsDispoPourCreneau(Integer id_creneau) {
        CreneauDisponibilite creneauDisponibilite = creneauDisponibiliteDAO.findById(id_creneau).get();
        return creneauDisponibilite.getProduits();
    }

    public Set<CreneauDisponibilite> getCreneauxPourProduit(Integer id_produit) {
        Produit produit = produitDAO.findById(id_produit).get();
        return produit.getCreneauDisponibilites();
    }
    public Produit findById(int id_produit) {
        return produitDAO.findById(id_produit).get();
    }
    public List<Produit> findByIdNot(int id_produit) {
        return produitDAO.findByIdNot(id_produit);

    }
    public List<Produit> search(String mot) {
        if (mot.equals("")) {
            return (List<Produit>) produitDAO.findAll();
        }
        else {
            return produitDAO.findByNomContainingIgnoreCaseOrCategorieContainingIgnoreCase(mot, mot);
        }
    }

    public List<Produit> ProduitRecent() {
        return produitDAO.ProduitRecent();
    }
}
