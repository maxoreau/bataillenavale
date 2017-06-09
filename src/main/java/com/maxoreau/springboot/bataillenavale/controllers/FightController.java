package com.maxoreau.springboot.bataillenavale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.maxoreau.springboot.bataillenavale.models.Player;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;

public class FightController {
				
					
	@Autowired	
	private GameRepository gameRepo;

	@Autowired
	private PlayerRepository playerRepo;

	//@PostMapping // Map ONLY POST Requests
	public void createPlayer(Player player) {
		System.out.println("Rest createPlayer() entered");
		System.out.println(player);
		playerRepo.save(player);
	}

	//@GetMapping
	public List<Player> getAllPlayers() {
		// This returns a JSON or XML with the users
		System.out.println("Rest getAllPlayers() entered");
		return (List<Player>) playerRepo.findAll();
	}

}
