package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxoreau.springboot.bataillenavale.factories.PlayerFactory;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;
/*
 * This class contains the logic between the program and the database by calling
 * the repositories when they should be called.
 */

@Service
public class GameManager {

	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerFactory playerFactory;

	private List<Game> games = new ArrayList<>();
	private List<Player> players = new ArrayList<>();

	public GameManager() {
		super();
	}

	@PostConstruct
	public void init() {
		System.out.println("initialisation du GameManager");
		games = (List<Game>) gameRepository.findAll();
		players = (List<Player>) playerRepository.findAll();
	}

	public List<Game> getAllGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		return games;
	}

	public void setAllGames(List<Game> games) {
		this.games = games;
	}

	/*
	 * add newly created game to the list then add it to the database This
	 * method should only be called from GameFactory
	 */
	public void addGame(Game game) {
		gameRepository.save(game);
		this.games = (List<Game>) gameRepository.findAll();
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
	
	public List<Game> getOpenGames() {
		List<Game> openGames = new ArrayList<>();
		for (Game game : games) {
			if (game.getStatus().equals(GameStatus.OPEN)) {
				openGames.add(game);
			}
		}
		return openGames;
	}
	

	public List<Game> getOpenGamesByPlayer(Player player) {
		List<Game> myOpenGames = new ArrayList<>();
		for (Game game : games) {
			if ((game.getStatus().equals(GameStatus.OPEN)) && ((game.getPlayer1().getId() == player.getId())
					|| (game.getPlayer2().getId() == player.getId()))) {
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

	public Player getPlayer(String name) {
		for (Player player : players) {
			if (player.getName().compareTo(name) == 0) {
				return player;
			}
		}
		return null;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/*
	 *  
	 */
	public boolean addPlayer(Player player) {
		if (playerRepository.findByName(player.getName()).isEmpty()) {
			playerFactory.createPlayer(player.getName());
			playerRepository.save(player);
			players.add(playerRepository.findByName(player.getName()).get(0));
			return true;
		}
		return false;
	}

	/*
	 * updates the attribute 'players' then updates the database
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
