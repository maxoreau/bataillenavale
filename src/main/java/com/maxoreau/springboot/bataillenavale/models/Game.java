package com.maxoreau.springboot.bataillenavale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Game {

	public enum GameStatus {
		OPEN, ONGOING, FINISHED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private GameStatus status = GameStatus.OPEN; // OPEN (attente d'un deuxieme joueur), ONGOING, FINISHED
	
	@OneToOne
	private Player currentPlayer;
	@OneToOne
	private Player player1;
	@OneToOne
	private Player player2;
	@OneToOne
	private Grid gridPlayer1;
	@OneToOne
	private Grid gridPlayer2;
	@OneToOne
	private Player winner;
	private int onGoingMove;
	private int player1Life;
	private int player2Life;

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

	public int getOnGoingMove() {
		return onGoingMove;
	}

	public void setOnGoingMove(int onGoingMove) {
		this.onGoingMove = onGoingMove;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public int getPlayer1Life() {
		return player1Life;
	}

	public void setPlayer1Life(int player1Life) {
		this.player1Life = player1Life;
	}

	public int getPlayer2Life() {
		return player2Life;
	}

	public void setPlayer2Life(int player2Life) {
		this.player2Life = player2Life;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", status=" + status + ", currentPlayer=" + currentPlayer + ", player1=" + player1
				+ ", player2=" + player2 + ", gridPlayer1=" + gridPlayer1 + ", gridPlayer2=" + gridPlayer2
				+ ", remainingMoves=" + onGoingMove + ", winner=" + winner + "]";
	}

	public void fireManager(Fire fire) {
		
		//final Integer player1Life;

		
		switch (status) {
		case OPEN:
			System.out.println("Wait for someone else to join game");
			break;
		case ONGOING:
			if (fire.getPlayer().equals(currentPlayer)) {

				// C'est bien au joueur qui tire de jouer
				if (currentPlayer.equals(player1)) {

					// le joueur 1 tire donc sur la grille du joueur 2
					gridPlayer2.fireManager(fire);
					currentPlayer = player2;
					onGoingMove++;

				} else {

					// le joueur 2 tire donc sur la grille du joueur 1
					gridPlayer1.fireManager(fire);
					currentPlayer = player1;
					onGoingMove++;
				}
			} else {
				// Ce n'est pas au joueur qui tire de jouer
				System.out.println("not " + fire.getPlayer().getName() + "'s turn");
			}

			if (onGoingMove > Parameters.getNbMoves() || player1Life == 0 || player2Life == 0) {
				System.out.println("Game Over");
				setStatus(GameStatus.FINISHED);
				if ((player1Life - player2Life) > 0) {
					// PLAYER 1 GAGNE
					winner = player1;					
				} else if ((player1Life - player2Life) < 0) {
					// PLAYER 2 GAGNE
					winner = player2;
				} else {
					// MATCH NUL					
				}
			}

			break;

		case FINISHED:
			System.out.println("Game is already over");
			break;
		}
	}

}
