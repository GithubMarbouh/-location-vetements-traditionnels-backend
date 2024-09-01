package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoutiqueRepository extends JpaRepository< Boutique,Integer> {
    @Query("select b from Boutique b where b.vendeur.id =  :id")
    Boutique getBoutiqueByVendeur(int id);
    @Query("SELECT b.id FROM Boutique b WHERE b.vendeur.email= :email")
    Integer getBoutiqueIdByVendeurEmail(String email);

}
