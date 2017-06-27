package com.maxoreau.springboot.bataillenavale.factories;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.maxoreau.springboot.bataillenavale.models.Player;

@Service
public class PlayerFactory {
	
	public PlayerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		System.out.println("initialisation du PlayerFactory");		
	}
	
	public Player createPlayer(String name) {
		Player player = new Player();
		player.setName(name);
		return player;
	}
	

}
