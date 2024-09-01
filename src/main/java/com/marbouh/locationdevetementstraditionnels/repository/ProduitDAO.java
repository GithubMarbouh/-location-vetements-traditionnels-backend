package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDAO extends CrudRepository<Produit,Integer> {
    List<Produit> findByIdNot(int id_produit);
    List<Produit> findByNomContainingIgnoreCaseOrCategorieContainingIgnoreCase(String nom, String categorie);
    @Query(value = "SELECT p FROM Produit p ORDER BY p.creationDate DESC")
    List<Produit> ProduitRecent();

}

