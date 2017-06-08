package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GameAdministrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static GameAdministrator gameAdmin;
	
	@OneToMany
	private List<Game> games;
	
	public GameAdministrator() {
		super();
	}

	public static GameAdministrator getGameAdmin() {
		if (gameAdmin == null) {
			gameAdmin = new GameAdministrator();
		}
		return gameAdmin;
	}

	public List<Game> getGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}
