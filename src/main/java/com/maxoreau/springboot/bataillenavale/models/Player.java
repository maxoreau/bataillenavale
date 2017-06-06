package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Player {

	private Long id;
	private String name;
	private List<Game> onGoingGames = new ArrayList<>();
	private int nbWins;

	public Player() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getOnGoingGames() {
		return onGoingGames;
	}

	public void setOnGoingGames(List<Game> onGoingGames) {
		this.onGoingGames = onGoingGames;
	}

	public int getNbWins() {
		return nbWins;
	}

	public void setNbWins(int nbWins) {
		this.nbWins = nbWins;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", onGoingGames=" + onGoingGames + ", nbWins=" + nbWins + "]";
	}

	public void fire(int x, int y){
		
	}
	
	public Game createGame(){
		Game game = new Game();
		game.setPlayer1(this);
		game.setRemainingMoves(Parameters.getNbMoves());
		this.onGoingGames.add(game);
		return game;
		
	}
	
	public Grid generateGrid(){
		System.out.println("generateGrid");
		return null;
		
	}
	
	public void enterGame(Game game){
		System.out.println("enterGame");		
	}
	
	

}
