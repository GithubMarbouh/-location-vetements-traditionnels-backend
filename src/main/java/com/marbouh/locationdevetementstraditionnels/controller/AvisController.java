package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Avis;
import com.marbouh.locationdevetementstraditionnels.repository.AvisRepository;
import com.marbouh.locationdevetementstraditionnels.services.UtilisateurService;
import com.marbouh.locationdevetementstraditionnels.services.impl.AvisService;
import com.marbouh.locationdevetementstraditionnels.services.impl.BoutiqueService;
import com.marbouh.locationdevetementstraditionnels.services.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
@CrossOrigin(origins = "http://localhost:4200")
public class AvisController {

    private final AvisService avisService;
    private final BoutiqueService boutiqueService;
    private final UtilisateurServiceImpl utilisateurService;
    private final AvisRepository avisRepository;


    public AvisController(AvisService avisService, BoutiqueService boutiqueService, UtilisateurServiceImpl utilisateurService, AvisRepository avisRepository){
        this.avisService = avisService;
        this.boutiqueService = boutiqueService;
        this.utilisateurService = utilisateurService;
        this.avisRepository = avisRepository;
    }

    @GetMapping
    public List<Avis> getAll() {
        return avisService.findAll();
    }

    @GetMapping("/{id}")
    public Avis getAvis(@PathVariable int id) {
        return avisService.findById(id);
    }

    @GetMapping("/test")
    public void test() {
        for (Avis a : boutiqueService.findById(39).getAvis()) {
            System.out.println(a.getCommentaire());
        }
    }

    @PostMapping
    public ResponseEntity<?> createAvis(@RequestParam("commentaire") String com , @RequestParam("id_boutique") int id_boutique , @RequestParam("id_client") int id_client ) {
        Avis avis = new Avis();
        avis.setCommentaire(com);
        avis.setBoutique(boutiqueService.findById(id_boutique));
        avis.setClient(utilisateurService.findById(id_client));
        avisService.save(avis);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public void updateAvis(@RequestBody Avis avis) {
        try {
            if (avis.getId() == null) {
                throw new IllegalArgumentException("Aucun id");
            }
            avisService.update(avis.getId().intValue());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Avis avis) {
        avisService.delete(avisService.findById(avis.getId().intValue()),
                boutiqueService.findById(avis.getBoutique().getId().intValue()));
    }

    @GetMapping("/boutique/{id}")
    public List<Avis> getAvisByBoutique(@PathVariable int id) {
        return avisRepository.getAvisBoutique(id);
    }
}