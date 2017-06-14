package com.maxoreau.springboot.bataillenavale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxoreau.springboot.bataillenavale.models.Fire;
import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.models.Grid;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;

@Controller		
@RequestMapping("/wb-battleship")
public class WebSocketGameController {
				
					
	@Autowired	
	private GameRepository gameRepo;

	@Autowired
	private PlayerRepository playerRepo;
	

	@MessageMapping("/openGames")
    @SendTo("/topic/")
	public List<Game> getOpenGames() {
		return (List<Game>) gameRepo.findByStatus(GameStatus.OPEN);	
	}
	
	@MessageMapping("/{gameId}")
    @SendTo("/topic/player1")
    public Grid greeting(Fire fire) throws Exception {
		
        return null;
    }


}
