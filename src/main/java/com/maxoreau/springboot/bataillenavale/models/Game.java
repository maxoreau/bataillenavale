package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Game implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	public enum GameStatus {
		OPEN, ONGOING, FINISHED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private GameStatus status = GameStatus.OPEN; // OPEN (attente d'un deuxieme joueur), ONGOING, FINISHED
	
	@OneToOne
	private Player currentPlayer;
	
	@ManyToOne
	private Player player1;
	
	@ManyToOne
	private Player player2;
	
	@ManyToOne
	private Player winner;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Grid gridPlayer1;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Grid gridPlayer2;
	
	private int onGoingMove;

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

	@Override
	public String toString() {
		return "Game [id=" + id + ", status=" + status + ", currentPlayer=" + currentPlayer + ", player1=" + player1
				+ ", player2=" + player2 + ", gridPlayer1=" + gridPlayer1 + ", gridPlayer2=" + gridPlayer2
				+ ", remainingMoves=" + onGoingMove + ", winner=" + winner + "]";
	}

	public void fireManager(Fire fire) {
		
	
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

			if (onGoingMove > Parameters.getNbMoves() || gridPlayer1.getLife() == 0 || gridPlayer2.getLife() == 0) {
				System.out.println("Game Over");
				setStatus(GameStatus.FINISHED);
				if ((gridPlayer1.getLife() - gridPlayer2.getLife()) > 0) {
					// PLAYER 1 GAGNE
					System.out.println(player1.getName() + " WINS : remaining life : " + gridPlayer1.getLife() + " / " + gridPlayer2.getLife());
					winner = player1;
					int nbWins = player1.getNbWins() + 1;
					player1.setNbWins(nbWins);
				} else if ((gridPlayer1.getLife() - gridPlayer2.getLife()) < 0) {
					// PLAYER 2 GAGNE
					System.out.println(player2.getName() + " WINS : remaining life : " + gridPlayer2.getLife() + " / " + gridPlayer1.getLife());
					winner = player2;
					int nbWins = player2.getNbWins() + 1;
					player2.setNbWins(nbWins);
				} else {
					// MATCH NUL
					System.out.println("DRAW : remaining life = " + gridPlayer1.getLife());					
				}
			}

			break;

		case FINISHED:
			System.out.println("Game is already over");
			break;
		}
	}

}
