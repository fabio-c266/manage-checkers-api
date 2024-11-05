package com.trabalhoundb.manage.checkers.api.infra.security;

import com.trabalhoundb.manage.checkers.api.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityService implements UserDetailsService {
    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.administratorRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Token inválido"));
    }
}
