package com.trabalhoundb.manage.checkers.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;
import com.trabalhoundb.manage.checkers.api.forms.UserPlayerForm;
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
	
	@PostMapping
	public ResponseEntity<UserPlayer> create(@RequestBody UserPlayerForm form) {
		UserPlayer userPlayer= form.converter();
		System.out.println(userPlayer.toString());
		
		playerRepository.save(userPlayer);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userPlayer.getId()).toUri();
		
		return ResponseEntity.created(uri).body(userPlayer);
	}	
}
