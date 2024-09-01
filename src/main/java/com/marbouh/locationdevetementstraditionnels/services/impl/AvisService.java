package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.model.Avis;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.repository.AvisRepository;
import com.marbouh.locationdevetementstraditionnels.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AvisService {
    AvisRepository avisRepository;
    BoutiqueService boutiqueService;
    UtilisateurService utilisateurService;

    @Autowired
    public AvisService(AvisRepository avisRepository, BoutiqueService boutiqueService) {
        this.avisRepository = avisRepository;
        this.boutiqueService = boutiqueService;
    }

    public ArrayList<Avis> findAll() {
        return new ArrayList<>(avisRepository.findAll());
    }

    public Avis findById(int id) {
        Optional<Avis> avis = avisRepository.findById(id);
        return avis.orElse(null);
    }

    //    public void save(Avis avis) {
//        try {
//
//            if (boutique != null) {
//                List<Avis> BoutiqueAvisList = boutique.getAvis();
//                if (!BoutiqueAvisList.contains(avis)) {
//                    BoutiqueAvisList.add(avis);
//                    avis.setBoutique(boutique);
//                    boutique.setAvis(BoutiqueAvisList);
//                    avis.setBoutique(boutique);
//                    avisRepository.save(avis);
//                }
//
//            } else System.out.println("Wa chriif ra la boutique makinach asslan");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            //Client client = boutiqueService.findById(avis.getBoutique().getId().intValue());
////avis.getClient().getAvis().add(avis);
//
//        }
//    }
    public Avis save(Avis avis) {
        return avisRepository.save(avis);
    }



    public void update (Integer id){

        try {
            if (id == null) {
                System.out.println("erorrr");
                throw new IllegalArgumentException("Aucun id");
            }
            Avis avis1 = avisRepository.findById(id).orElseThrow();
            avisRepository.save(avis1);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

//    public void deleteById(int id) {
//        System.out.println("id = " + id);
//        System.out.println(avisRepository.findById(id).get().getCommentaire());
//        avisRepository.delete(avisRepository.findById(id).get());
//
//    }

    public void delete (Avis avis, Boutique boutique){

        try {

            if (boutique != null) {
                List<Avis> BoutiqueAvisList = boutique.getAvis();

                if (BoutiqueAvisList.contains(avis)) {
                    BoutiqueAvisList.remove(avis);
                    avis.setBoutique(null);

                    avisRepository.delete(avis);

                }

            } else System.out.println("Wa chriif ra la boutique makinach asslan");

        } catch (Exception e) {
            e.printStackTrace();

            //Client client = boutiqueService.findById(avis.getBoutique().getId().intValue());
//avis.getClient().getAvis().add(avis);

        }

    }

}