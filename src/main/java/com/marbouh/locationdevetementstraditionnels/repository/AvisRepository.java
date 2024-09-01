package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Avis;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AvisRepository extends JpaRepository<Avis,Integer> {
    @Query("Select a from Avis a")
    List<Avis> getAvis();
    @Query("Select a from Avis a where a.boutique.id = :id")
    List<Avis> getAvisBoutique(int id);
}
