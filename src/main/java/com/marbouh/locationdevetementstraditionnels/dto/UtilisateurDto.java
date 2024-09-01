package com.marbouh.locationdevetementstraditionnels.dto;

import com.marbouh.locationdevetementstraditionnels.model.Role;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UtilisateurDto extends Throwable {
     private Integer id;
     private String nom;
     private String prenom;
     private String email;
     private String moteDePasse;
     private AdresseDto adresse;
     private String telephone;
     private Role role;
        public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
            if (utilisateur == null) {
                return null;
            }
            return UtilisateurDto.builder()
                    .id(utilisateur.getId())
                    .nom(utilisateur.getNom())
                    .prenom(utilisateur.getPrenom())
                    .email(utilisateur.getEmail())
                    .moteDePasse(utilisateur.getMotDePasse())
                    .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                    .telephone(utilisateur.getTelephone())
                    .role(utilisateur.getRole())
                    .build();
        }

        public static Utilisateur toEntity(UtilisateurDto dto) {
            if (dto == null) {
                return null;
            }
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(dto.getId());
            utilisateur.setNom(dto.getNom());
            utilisateur.setPrenom(dto.getPrenom());
            utilisateur.setEmail(dto.getEmail());
            utilisateur.setMotDePasse(dto.getMoteDePasse());
            utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
            utilisateur.setTelephone(dto.getTelephone());

            return utilisateur;
        }



}
