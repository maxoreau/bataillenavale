package com.maxoreau.springboot.bataillenavale.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.GameManager;
import com.maxoreau.springboot.bataillenavale.models.Player;

@Service
public class GameFactory {
	
	@Autowired
	private GameManager gameManager;
	@Autowired
	private GridFactory gridFactory;
	
	public GameFactory() {
		super();
	}

	// Creation d'une partie par un joueur
	public Game createGame(Player p){
		Game game = new Game();
		
		// on passe directement le joueur créateur en tant que joueur 1
		game.setPlayer1(p); 
		
		// Optionnal : on instancie le numéro de tour à 0
		game.setOnGoingMove(0); 
		
		// on attribue des nouvelles grilles aux joueurs. Utilisation d'une factory
		game.setGridPlayer1(gridFactory.createGrid());

		game.setGridPlayer2(gridFactory.createGrid());

		// le joueur qui crée la partie commencera à jouer.
		game.setCurrentPlayer(p); 
		
		// on passe la partie en tant que partie en cours pour le joueur qui crée la partie
		p.setOnGoingGame(game); 
		// puis on ajoute cette partie à la liste des parties du joueur
		p.getGames().add(game); 
		
		// enregistre dans la liste totale des parties
		gameManager.addGame(game);
		gameManager.updatePlayer(p);
		return game;
	}
	

}
