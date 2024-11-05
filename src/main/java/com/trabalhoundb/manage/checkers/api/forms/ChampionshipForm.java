package com.trabalhoundb.manage.checkers.api.forms;

import java.util.Date;

import com.trabalhoundb.manage.checkers.api.entities.Championship;
import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;
import com.trabalhoundb.manage.checkers.api.repositories.ChampionshipRepository;
import com.trabalhoundb.manage.checkers.api.repositories.UserPlayerRepository;

import jakarta.validation.constraints.NotNull;

public class ChampionshipForm {
	
	@NotNull
    private String name;
	@NotNull
    private String description;
	@NotNull
    private int maxPlayers;
	@NotNull
    private int minPoints;
	@NotNull
    private Double registrationFee;
	@NotNull
    private Date endSubscriptions;
	@NotNull
    private Date startedAt;
	@NotNull
	private Date endedAt;
	@NotNull
    private Long userPlayerId;
	
	public Championship converter(UserPlayerRepository playerRepository, Long userId) {
		UserPlayer userPlayer = playerRepository.findById(userId).get();
		return new Championship(name, description, maxPlayers, minPoints, registrationFee, endSubscriptions, startedAt, endedAt, userPlayer);
	}

}
