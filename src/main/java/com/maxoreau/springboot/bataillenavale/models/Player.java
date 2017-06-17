package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.maxoreau.springboot.bataillenavale.factories.GameFactory;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Player implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Transient
	private List<Game> games = new ArrayList<>();
	
	@ManyToOne
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

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
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
		return "Player [id=" + id + ", name=" + name + ", games=" + games + ", onGoingGame=" + onGoingGame + ", nbWins="
				+ nbWins + "]";
	}

	public void fire(int col, int row) {
		Fire fire = new Fire();
		fire.setPlayer(this);
		fire.setCol(col);
		fire.setRow(row);
		onGoingGame.fireManager(fire);
	}

	public Game createGame() {
		System.out.println("player " + this.name + " creates game");
		return GameFactory.getGameFactory().createGame(this);
	}

	public void enterGame(Game game) {
		System.out.println("player " + this.name + " enters game");
		
		// La partie est en attente d'un deuxieme joueur et on peut y accéder
		if (game.getStatus().equals(GameStatus.OPEN)) { 
			
			// on attribue le deuxième joueur de la partie
			game.setPlayer2(this); 	
			
			// On initialise le tour en cours à un pour commencer la partie
			game.setOnGoingMove(1); 
			
			// on passe le statut de la partie à ONGOING pour la fermer aux autres joueurs
			game.setStatus(GameStatus.ONGOING);
			
			// cette partie devient la partie en cours et est ajoutée à la liste des parties
			onGoingGame = game;
			games.add(onGoingGame);
			GameManager.getGameManager().updateGame(game);
						
			
		// La partie est déjà en cours et le joueur appartient à la partie, il peut alors la rejoindre
		} else if ((game.getStatus().equals(GameStatus.ONGOING))
				&& ((game.getPlayer1().equals(this)) || (game.getPlayer2().equals(this)))) {
			
			// cette partie devient la partie en cours.
			onGoingGame = game;
		}
	}

	public void leftGame() {

	}

}
