package com.trabalhoundb.manage.checkers.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;
import com.trabalhoundb.manage.checkers.api.repositories.UserPlayerRepository;

@RestController
@RequestMapping("/users")
public class UserPlayerController {
	
	@Autowired
	private UserPlayerRepository playerRepository;
	
	@GetMapping
	public ResponseEntity<List<UserPlayer>> findUsers(String userName) {
		
		if (userName  != null) {
			List<UserPlayer> userplayers = playerRepository.findByNameContainingIgnoreCase(userName);
			return ResponseEntity.ok().body(userplayers);
		}
		else {
			List<UserPlayer> userplayers = playerRepository.findAll();
			return ResponseEntity.ok().body(userplayers);
		}
	}
}
