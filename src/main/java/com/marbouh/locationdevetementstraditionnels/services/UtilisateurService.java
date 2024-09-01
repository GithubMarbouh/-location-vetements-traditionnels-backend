package com.marbouh.locationdevetementstraditionnels.services;

import com.marbouh.locationdevetementstraditionnels.dto.UtilisateurDto;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {

        UtilisateurDto save(UtilisateurDto dto);


        UtilisateurDto findById(Integer id);

        List<UtilisateurDto> findAll();

        void delete(Integer id);

        UtilisateurDto findByEmail(String email);


}
