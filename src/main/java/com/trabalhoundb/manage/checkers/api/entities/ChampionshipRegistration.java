package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ChampionshipRegistration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userPlayer")
	private UserPlayer userPlayer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "championship")
	private Championship championship;

	public ChampionshipRegistration(UserPlayer userPlayer, Championship championship) {
		super();
		this.userPlayer = userPlayer;
		this.championship = championship;
	}
	

}
