package com.trabalhoundb.manage.checkers.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;

public interface UserPlayerRepository extends JpaRepository<UserPlayer, Long>{
	
	List<UserPlayer> findByNameContainingIgnoreCase(String name);

}
