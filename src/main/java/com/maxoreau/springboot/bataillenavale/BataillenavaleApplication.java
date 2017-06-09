package com.maxoreau.springboot.bataillenavale;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.models.Parameters;
import com.maxoreau.springboot.bataillenavale.models.Player;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;

@SpringBootApplication
public class BataillenavaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BataillenavaleApplication.class, args);
//		
//		Player p1 = new Player();
//		p1.setName("p1");
//
//		Player p2 = new Player();
//		p2.setName("p2");
//
//		
//		
//		Long debut = System.currentTimeMillis();
//		Game g1 = p1.createGame();
//		Long fin = System.currentTimeMillis();
//		System.out.println("jeu généré en " + (fin - debut) + " millisecondes");
//		p2.enterGame(g1);
//		
//		
//		do {
//			int colA = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//			int rowA = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//			p1.fire(colA, rowA);
//			System.out.println("player2's grid");
//			g1.getGridPlayer2().displayOwnGrid();
//			
//			int colB = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//			int rowB = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//			p2.fire(colB, rowB);
//			System.out.println("player1's grid");
//			g1.getGridPlayer1().displayOwnGrid();
//			
//		} while (g1.getStatus().compareTo(GameStatus.ONGOING) == 0);

		
		
	}

	// args correspond à command linerunner
//	@Bean
	public CommandLineRunner demo(PlayerRepository playerRepo, GameRepository gameRepo) {
		return (args) -> {

//			Player p1 = new Player();
//			p1.setName("p1");
//
//			Player p2 = new Player();
//			p2.setName("p2");
//
//			Long debut = System.currentTimeMillis();
//			Game g1 = p1.createGame();
//			Long fin = System.currentTimeMillis();
//			System.out.println("jeu généré en " + (fin - debut) + " millisecondes");
//			p2.enterGame(g1);
//			
//			
//			do {
//				int colA = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//				int rowA = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//				p1.fire(colA, rowA);
//				System.out.println("player2's grid");
//				g1.getGridPlayer2().displayOwnGrid();
//				
//				int colB = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//				int rowB = ThreadLocalRandom.current().nextInt(0, (Parameters.getGridSize()));
//				p2.fire(colB, rowB);
//				System.out.println("player1's grid");
//				g1.getGridPlayer1().displayOwnGrid();
//				
//			} while (g1.getStatus().compareTo(GameStatus.ONGOING) == 0);
//
//			
//			playerRepo.save(p1);
//			playerRepo.save(p2);
//			gameRepo.save(g1);
			

		};
	}
}
