package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;


@Component
public class GameManager {
	
	@Autowired
	GameRepository daoGame;
	@Autowired
	PlayerRepository daoPlayer;
		
	private static List<Game> games = new ArrayList<>();
	private static List<Player> players = new ArrayList<>();
	
	public GameManager() {
		super();
	}
	
	@PostConstruct
	public void init() {
		GameManager.games = (List<Game>) daoGame.findAll();
		GameManager.players = (List<Player>) daoPlayer.findAll();		
	}

	public static List<Game> getGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		return games;
	}

	public void setGames(List<Game> games) {
		GameManager.games = games;
	}

	public static List<Player> getPlayers() {
		if (players == null) {
			players = new ArrayList<>();			
		}
		return players;
	}

	public void setPlayers(List<Player> players) {
		GameManager.players = players;
	}

}
