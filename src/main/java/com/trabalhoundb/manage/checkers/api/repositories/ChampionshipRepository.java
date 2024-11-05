package com.trabalhoundb.manage.checkers.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoundb.manage.checkers.api.entities.Championship;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long>{
	
	List<Championship> findByNameContainingIgnoreCase(String name);

}
