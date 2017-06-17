package com.maxoreau.springboot.bataillenavale.factories;

import com.maxoreau.springboot.bataillenavale.models.Player;

public class PlayerFactory {
	
	private static PlayerFactory playerFactory;
	
	private PlayerFactory() {
		// TODO Auto-generated constructor stub
	}

	public static PlayerFactory getPlayerFactory() {
		if (playerFactory == null) {
			playerFactory = new PlayerFactory();
		}
		return playerFactory;
	}
	
	public Player createPlayer(String name) {
		Player player = new Player();
		player.setName(name);
		return player;
	}
	

}
