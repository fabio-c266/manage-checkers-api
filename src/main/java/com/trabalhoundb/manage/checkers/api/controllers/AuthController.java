package com.trabalhoundb.manage.checkers.api.controllers;

import com.trabalhoundb.manage.checkers.api.dtos.TokenResponseDTO;
import com.trabalhoundb.manage.checkers.api.dtos.UserCredentialsDTO;
import com.trabalhoundb.manage.checkers.api.entities.Administrator;
import com.trabalhoundb.manage.checkers.api.infra.security.TokenService;
import com.trabalhoundb.manage.checkers.api.repositories.AdministratorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> authenticate(@RequestBody @Valid UserCredentialsDTO userCredentialsDTO) throws Exception {
        Optional<Administrator> administrator = administratorRepository.findByEmail(userCredentialsDTO.email());

        if (administrator.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (!passwordEncoder.matches(userCredentialsDTO.password(), administrator.get().getPasswordHashed())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = this.tokenService.generateToken(administrator.get());

        if (token == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(
                new TokenResponseDTO(token)
        );
    }
}
