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

import com.trabalhoundb.manage.checkers.api.entities.Championship;
import com.trabalhoundb.manage.checkers.api.entities.ChampionshipRegistration;
import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;
import com.trabalhoundb.manage.checkers.api.forms.ChampionshipForm;
import com.trabalhoundb.manage.checkers.api.repositories.ChampionshipRegistrationRepository;
import com.trabalhoundb.manage.checkers.api.repositories.ChampionshipRepository;
import com.trabalhoundb.manage.checkers.api.repositories.UserPlayerRepository;

@RestController
@RequestMapping("/championship")
public class ChampionshipController {
	
	@Autowired
	private ChampionshipRepository championshipRepository;
	
	@Autowired
	private UserPlayerRepository userPlayerRepository;
	
	@Autowired
	private ChampionshipRegistrationRepository registrationRepository;
	
	@GetMapping
	public ResponseEntity<List<Championship>> show(String champName) {
		
		if (champName == null) {
			List<Championship> championships  = championshipRepository.findAll();
			return ResponseEntity.ok().body(championships);
		}
		else {
			List<Championship> championships  = championshipRepository.findByNameContainingIgnoreCase(champName);
			return ResponseEntity.ok().body(championships);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Championship> create(@RequestBody ChampionshipForm form, Long userId) {
		Championship championship = form.converter(userPlayerRepository, userId);
		Championship obj = championshipRepository.save(championship);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}	
	
	@PostMapping("/register")
	public ResponseEntity<ChampionshipRegistration> registerIn(Long ChampionshipId, Long userId) {
		Championship championship = championshipRepository.getReferenceById(ChampionshipId);
		 UserPlayer userPlayer = userPlayerRepository.getReferenceById(userId);
		 
		ChampionshipRegistration registration = new ChampionshipRegistration(userPlayer, championship);
		
		ChampionshipRegistration obj = registrationRepository.save(registration);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
