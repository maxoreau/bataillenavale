package com.maxoreau.springboot.bataillenavale.models;

import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.maxoreau.springboot.bataillenavale.factories.PlayerFactory;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;
/*
 * This class contains the logic between the program and the database by calling
 * the repositories when they should be called.
 */

@Component
public class GameManager {
	
	private static GameManager gameManager;
	
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private PlayerRepository playerRepository;
		
	private static List<Game> games = new ArrayList<>();
	private static List<Player> players = new ArrayList<>();
	
	private GameManager() {
		super();
	}
	
	public static GameManager getGameManager() {
		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}
	
	@PostConstruct
	public void init() {
		GameManager.games = (List<Game>) gameRepository.findAll();
		GameManager.players = (List<Player>) playerRepository.findAll();		
	}

	public List<Game> getAllGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		return games;
	}

	public void setAllGames(List<Game> games) {
		GameManager.games = games;
	}
	
	/*
	 * add newly created game to the list then add it to the database
	 * This method should only be called from GameFactory
	 */
	public void addGame(Game game) {
		gameRepository.save(game);
		GameManager.games = (List<Game>) gameRepository.findAll();
	}
	
	/*
	 * updates the attribute 'games' then the database
	 */
	public void updateGame(Game game) {
		for (Game g : games) {
			if (game.getId() == g.getId()) {
				g = game;				
			}
		}
		Game fetchedGame = gameRepository.findOne(game.getId());
		fetchedGame = game;
		gameRepository.save(fetchedGame);
	}
	
	public List<Game> getOpenGamesByPlayer(Player player){
		List<Game> myOpenGames = new ArrayList<>();
		for (Game game : games) {
			if ((game.getStatus().equals(GameStatus.OPEN)) && ((game.getPlayer1().getId() == player.getId()) || (game.getPlayer2().getId() == player.getId()))) {
				myOpenGames.add(game);
			}
		}		
		return myOpenGames;
	}

	public List<Player> getPlayers() {
		if (players == null) {
			players = new ArrayList<>();			
		}
		return players;
	}

	public void setPlayers(List<Player> players) {
		GameManager.players = players;
	}
	
	/*
	 *  
	 */
	public boolean addPlayer(Player player) {
    	if (playerRepository.findByName(player.getName()).isEmpty()) {
    		PlayerFactory.getPlayerFactory().createPlayer(player.getName());     		
    		playerRepository.save(player);
    		players.add(playerRepository.findByName(player.getName()).get(0));
    		return true;
		}		
		return false;
	}
	
	/*
	 * updates the attribute 'payers' then updates the database
	 */
	public void updatePlayer(Player player) {
		Player fetchedPlayer = playerRepository.findByName(player.getName()).get(0);
		fetchedPlayer = player;
		playerRepository.save(fetchedPlayer);
		
		for (Player p : players) {
			if (player.getId() == p.getId()) {
				p = player;				
			}
		}
		
	}

}
