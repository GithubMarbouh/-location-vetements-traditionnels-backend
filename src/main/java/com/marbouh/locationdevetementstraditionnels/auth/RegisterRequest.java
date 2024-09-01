package com.marbouh.locationdevetementstraditionnels.auth;

import com.marbouh.locationdevetementstraditionnels.dto.AdresseDto;
import com.marbouh.locationdevetementstraditionnels.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private Integer id;
  private String nom;
  private String prenom;
  private String email;
  private String moteDePasse;
  private AdresseDto adresse;
  private String telephone;
  private Role role;
}
