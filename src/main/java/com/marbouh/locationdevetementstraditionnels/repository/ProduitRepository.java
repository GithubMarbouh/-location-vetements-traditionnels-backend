package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    List<Produit> findByIdNot(int id_produit);
    List<Produit> findByNomContainingIgnoreCaseOrCategorieContainingIgnoreCase(String nom, String categorie);
}
