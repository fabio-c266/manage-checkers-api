package com.trabalhoundb.manage.checkers.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoundb.manage.checkers.api.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
