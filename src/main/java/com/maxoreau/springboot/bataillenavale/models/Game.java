package com.maxoreau.springboot.bataillenavale.models;

import javax.persistence.Entity;

@Entity
public class Game {
	
	public enum GameStatus {OPEN, ONGOING, FINISHED}
	
	private Long id;
	private GameStatus status = GameStatus.OPEN;	// OUVERTE (attente d'un deuxieme joueur), ENCOURS, TERMINEE
	private Player currentPlayer; 	// 1 pour joueur 1 et 2 pour joueur 2.
	private Player player1;
	private Player player2;
	private Grid gridPlayer1;
	private Grid gridPlayer2;
	private int remainingMoves;
	private Player winner;
	
	public Game() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Grid getGridPlayer1() {
		return gridPlayer1;
	}

	public void setGridPlayer1(Grid gridPlayer1) {
		this.gridPlayer1 = gridPlayer1;
	}

	public Grid getGridPlayer2() {
		return gridPlayer2;
	}

	public void setGridPlayer2(Grid gridPlayer2) {
		this.gridPlayer2 = gridPlayer2;
	}

	public int getRemainingMoves() {
		return remainingMoves;
	}

	public void setRemainingMoves(int remainingMoves) {
		this.remainingMoves = remainingMoves;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", status=" + status + ", currentPlayer=" + currentPlayer + ", player1=" + player1
				+ ", player2=" + player2 + ", gridPlayer1=" + gridPlayer1 + ", gridPlayer2=" + gridPlayer2
				+ ", remainingMoves=" + remainingMoves + ", winner=" + winner + "]";
	}
	
	
}
