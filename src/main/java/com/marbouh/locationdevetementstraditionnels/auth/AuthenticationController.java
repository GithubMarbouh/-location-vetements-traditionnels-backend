package com.marbouh.locationdevetementstraditionnels.auth;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.services.impl.UtilisateurServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  private final UtilisateurServiceImpl utilisateurService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @GetMapping("/confirm")
  public ResponseEntity<String> confirm(@RequestParam String token) {
    String responseMessage = service.confirmToken(token);
    return ResponseEntity.ok(responseMessage);
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }

  @GetMapping("/id")
  public Integer getId(@RequestParam("email") String email) {
    return utilisateurService.findId(email);
  }

  @GetMapping("/{id}")
    public Utilisateur getUtilisateur(@PathVariable("id") int id) {
        return utilisateurService.findById(id);
    }
}
