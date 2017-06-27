package com.maxoreau.springboot.bataillenavale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxoreau.springboot.bataillenavale.factories.PlayerFactory;
import com.maxoreau.springboot.bataillenavale.jsonmodels.PlayerJson;
import com.maxoreau.springboot.bataillenavale.models.Fire;
import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.models.GameManager;
import com.maxoreau.springboot.bataillenavale.models.Grid;
import com.maxoreau.springboot.bataillenavale.models.Player;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;

@Controller
public class WebSocketGameController {
				
					
	@Autowired	
	private GameRepository gameRepo;

	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private GameManager gameManager;
	
	@Autowired
	private PlayerFactory playerFactory;
		

	//@MessageMapping("/openGames")
    @SendTo("/topic/opengames")
	public List<Game> getOpenGames() {
		return (List<Game>) gameRepo.findByStatus(GameStatus.OPEN);	
	}
	
	@MessageMapping("/connect")
    @SendTo("/topic/connected")
    public PlayerJson greeting(String name) throws Exception {
		System.out.println(name);
		Player player = new Player();
		player.setName(name);
		gameManager.addPlayer(player);		
        return new PlayerJson(gameManager.getPlayer(name));
    }


}
