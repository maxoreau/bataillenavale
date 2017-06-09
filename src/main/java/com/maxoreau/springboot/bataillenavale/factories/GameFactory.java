package com.maxoreau.springboot.bataillenavale.factories;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.GameManager;
import com.maxoreau.springboot.bataillenavale.models.Player;

public class GameFactory {

	private static GameFactory gameFactory;
	
	public GameFactory() {
		super();
	}

	public static GameFactory getGameFactory() {
		if (gameFactory == null) {
			gameFactory = new GameFactory();
		}
		return gameFactory;
	}
	
	// Creation d'une partie par un joueur
	public Game createGame(Player p){
		Game game = new Game();
		
		// on passe directement le joueur créateur en tant que joueur 1
		game.setPlayer1(p); 
		
		// Optionnal : on instancie le numéro de tour à 0
		game.setOnGoingMove(0); 
		
		// on attribue des nouvelles grilles aux joueurs. Utilisation d'une factory
		game.setGridPlayer1(GridFactory.getGridFactory().createGrid());

		game.setGridPlayer2(GridFactory.getGridFactory().createGrid());

		// le joueur qui crée la partie commencera à jouer.
		game.setCurrentPlayer(p); 
		
		// on passe la partie en tant que partie en cours pour le joueur qui crée la partie
		p.setOnGoingGame(game); 
		// puis on ajoute cette partie à la liste des parties du joueur
		p.getGames().add(game); 
		
		// enregistre dans la liste totale des parties
		GameManager.getGames().add(game); 
		return game;
	}
	

}
