package com.trabalhoundb.manage.checkers.api.repositories;

import com.trabalhoundb.manage.checkers.api.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByEmail(String email);
}
