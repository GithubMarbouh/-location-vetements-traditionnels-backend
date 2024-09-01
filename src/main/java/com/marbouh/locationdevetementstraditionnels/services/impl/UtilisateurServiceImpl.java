package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.dto.UtilisateurDto;
import com.marbouh.locationdevetementstraditionnels.exception.ErrorCodes;
import com.marbouh.locationdevetementstraditionnels.exception.InvalidEntityException;
import com.marbouh.locationdevetementstraditionnels.exception.InvalidOperationException;
import com.marbouh.locationdevetementstraditionnels.model.Role;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.repository.LocationRepository;
import com.marbouh.locationdevetementstraditionnels.repository.ReservationRepository;
import com.marbouh.locationdevetementstraditionnels.repository.UtilisateurRepository;
import com.marbouh.locationdevetementstraditionnels.services.UtilisateurService;
import com.marbouh.locationdevetementstraditionnels.token.TokenRepository;
import com.marbouh.locationdevetementstraditionnels.validator.UtilisateurValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository,
                                  PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));

        }
        if (userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }
        dto.setMoteDePasse(passwordEncoder.encode(dto.getMoteDePasse()));
       return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                )
        );
    }
    private boolean userAlreadyExists(String email) {
    Optional<Utilisateur> utilisateur=utilisateurRepository.findByEmail(email);
    return utilisateur.isPresent();
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new InvalidEntityException(
                        "Aucun utilisateur avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);

    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new InvalidEntityException(
                        "Aucun utilisateur avec l'email = " + email + " n'ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );


    }

    public Integer findId(String email){
      return utilisateurRepository.findIdByEmail(email);
    }

    public Utilisateur findById(int id){
        return utilisateurRepository.findbyId(id);
    }

    public Utilisateur update(Utilisateur utilisateur){
        if (utilisateur == null) {
            log.error("Utilisateur is null");
            return null;
        }
        return utilisateurRepository.save(utilisateur);
    }
     //Supprime ce bout de code
        public void changeRoleToSeller(Utilisateur user) {
            user.setRole(Role.MANAGER);
            utilisateurRepository.save(user);
        }
    @Transactional
    public void deleteById(int id) {
        tokenRepository.deleteByUserId(id);
        locationRepository.deleteByClientId(id);
        reservationRepository.deleteByClientId(id);
        utilisateurRepository.deleteById(id);
    }
 public List<Utilisateur> getAllClient(){
        return utilisateurRepository.getAllClient();
    }

}
