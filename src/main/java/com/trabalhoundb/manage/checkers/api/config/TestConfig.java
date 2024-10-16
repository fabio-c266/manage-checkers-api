package com.trabalhoundb.manage.checkers.api.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.trabalhoundb.manage.checkers.api.entities.Address;
import com.trabalhoundb.manage.checkers.api.entities.City;
import com.trabalhoundb.manage.checkers.api.entities.State;
import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;
import com.trabalhoundb.manage.checkers.api.enums.GenderTypes;
import com.trabalhoundb.manage.checkers.api.repositories.AddressRepository;
import com.trabalhoundb.manage.checkers.api.repositories.CityRepository;
import com.trabalhoundb.manage.checkers.api.repositories.StateRepository;
import com.trabalhoundb.manage.checkers.api.repositories.UserPlayerRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
		@Autowired
	    private UserPlayerRepository userPlayerRepository;

	    @Autowired
	    private AddressRepository addressRepository;

	    @Autowired
	    private CityRepository cityRepository;

	    @Autowired
	    private StateRepository stateRepository;

	    @Override
	    public void run(String... args) throws Exception {
	        // Criando estados
	        State sp = new State(null, "SP", "São Paulo");
	        State rj = new State(null, "RJ", "Rio de Janeiro");
	        stateRepository.save(sp);
	        stateRepository.save(rj);

	        // Criando cidades
	        City saoPaulo = new City(null, "São Paulo", sp);
	        City rioDeJaneiro = new City(null, "Rio de Janeiro", rj);
	        cityRepository.save(saoPaulo);
	        cityRepository.save(rioDeJaneiro);

	        // Criando jogadores
	        // GenderTypes.M  GenderTypes.F
	        UserPlayer player1 = new UserPlayer(null, "M", "João Silva", "joaosilva", "12345678900", "11987654321", 
	                        "joao@example.com", "hashedPassword", 0L, 0L, 0L, true, new Date(), null);
	        UserPlayer player2 = new UserPlayer(null, "F", "Maria Souza", "mariasouza", "98765432100", "21987654321", 
	                        "maria@example.com", "hashedPassword", 0L, 0L, 0L, true, new Date(), null);
	        userPlayerRepository.save(player1);
	        userPlayerRepository.save(player2);
	        
	     // Criando endereços
	        Address address1 = new Address(null, "01001000", "Rua A", "Centro", "Apto 101", 123, player1, saoPaulo);
	        Address address2 = new Address(null, "20020000", "Rua B", "Copacabana", null, 456, player2, rioDeJaneiro);
	        player1.setAddress(address1);
	        player2.setAddress(address2);
	        addressRepository.save(address1);
	        addressRepository.save(address2);
	        userPlayerRepository.save(player1);
	        userPlayerRepository.save(player2);
	    }

}
