package com.maxoreau.springboot.bataillenavale.factories;

import org.springframework.stereotype.Service;

import com.maxoreau.springboot.bataillenavale.models.Player;

@Service
public class PlayerFactory {
	
	public PlayerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Player createPlayer(String name) {
		Player player = new Player();
		player.setName(name);
		return player;
	}
	

}
