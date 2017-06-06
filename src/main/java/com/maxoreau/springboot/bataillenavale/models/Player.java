package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;

import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;

//@Entity
public class Player {

	private Long id;
	private String name;
	private List<Game> onGoingGames = new ArrayList<>();
	private Game onGoingGame;
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

	public Game getOnGoingGame() {
		return onGoingGame;
	}

	public void setOnGoingGame(Game onGoingGame) {
		this.onGoingGame = onGoingGame;
	}

	public int getNbWins() {
		return nbWins;
	}

	public void setNbWins(int nbWins) {
		this.nbWins = nbWins;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", onGoingGames=" + onGoingGames + ", onGoingGame=" + onGoingGame
				+ ", nbWins=" + nbWins + "]";
	}

	public void fire(int x, int y){
		
	}
	
	public Game createGame(){
		Game game = new Game();
		game.setPlayer1(this);
		game.setRemainingMoves(Parameters.getNbMoves());
		onGoingGame = game;
		this.onGoingGames.add(game);
		return game;
		
	}
	
	public void generateGrid(){
		System.out.println("generateGrid");
		if (onGoingGame.getStatus().compareTo(GameStatus.OPEN) == 0) {
			if (this.equals(onGoingGame.getPlayer1())) {
				onGoingGame.setGridPlayer1(new Grid());
			} else {
				onGoingGame.setGridPlayer2(new Grid());
			}
		}
		
	}
	
	public void enterGame(Game game){
		System.out.println("enterGame");
		onGoingGame = game;
	}
	
	

}
