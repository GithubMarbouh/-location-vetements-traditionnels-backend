package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.repository.BoutiqueRepository;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoutiqueService {
    private final UtilisateurServiceImpl utilisateurServiceImpl;
    BoutiqueRepository boutiqueRepository;
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository, UtilisateurRepository utilisateurRepository, UtilisateurServiceImpl utilisateurServiceImpl) {
        this.boutiqueRepository = boutiqueRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurServiceImpl = utilisateurServiceImpl;
    }

    public ArrayList<Boutique> findAll() {
        return new ArrayList<>(boutiqueRepository.findAll());
    }

    public Boutique findById(int id) {
        Optional<Boutique> boutique = boutiqueRepository.findById(id);
        return boutique.orElse(null);
    }

    public void saveOrUpdate(Boutique boutique, Utilisateur user) {
        utilisateurServiceImpl.changeRoleToSeller(user);
        if (boutique.getId() == null) {
            Boutique boutique1 = new Boutique(boutique.getNom(), boutique.getAdresse(), boutique.getTelephone(), boutique.getEmail(), boutique.getSiteweb(), boutique.getHoraire(), user);
            boutiqueRepository.save(boutique1);
            utilisateurServiceImpl.changeRoleToSeller(user);
        }else{
            boutiqueRepository.saveAndFlush(boutique);
        }
    }

    public void deleteById(int id) {
        boutiqueRepository.deleteById(id);
    }

    public List getAllProduitsFromBoutique(Integer id_boutique) {
        Boutique boutique = boutiqueRepository.findById(id_boutique).get();
        return boutique.getProduits();
    }
    public Boutique update(Boutique boutique){
        return boutiqueRepository.saveAndFlush(boutique);
}
    public Boutique getBoutiqueByClient(int id){
       return boutiqueRepository.getBoutiqueByVendeur(id);
    }
    public Integer getBoutiqueIdByVendeurEmail(String email){
        return boutiqueRepository.getBoutiqueIdByVendeurEmail(email);
    }
}
