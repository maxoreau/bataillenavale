package com.maxoreau.springboot.bataillenavale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Location;
import com.maxoreau.springboot.bataillenavale.models.Player;
import com.maxoreau.springboot.bataillenavale.repositories.GameRepository;
import com.maxoreau.springboot.bataillenavale.repositories.PlayerRepository;

@SpringBootApplication
public class BataillenavaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BataillenavaleApplication.class, args);
	}

	// args correspond à command linerunner
	@Bean
	public CommandLineRunner demo(PlayerRepository playerRepo, GameRepository gameRepo) {
		return (args) -> {

			Player p1 = new Player();
			p1.setName("p1");

			Player p2 = new Player();
			p2.setName("p2");

			Long debut = System.currentTimeMillis();
			Game g1 = p1.createGame();
			Long fin = System.currentTimeMillis();
			System.out.println("jeu généré en " + (fin - debut) + " millisecondes");
			p2.enterGame(g1);

			p1.fire(0, 0);
			System.out.println("player2's grid");
			g1.getGridPlayer2().displayEnemyGrid();
			
			p2.fire(0, 0);
			System.out.println("player1's grid");
			g1.getGridPlayer1().displayEnemyGrid();
			
			p1.fire(1, 1);
			System.out.println("player2's grid");
			g1.getGridPlayer2().displayEnemyGrid();
			
			p2.fire(2, 9);
			System.out.println("player1's grid");
			g1.getGridPlayer1().displayEnemyGrid();
			
			p1.fire(5, 5);
			System.out.println("player2's grid");
			g1.getGridPlayer2().displayEnemyGrid();
			
			p2.fire(2, 6);
			System.out.println("player1's grid");
			g1.getGridPlayer1().displayEnemyGrid();
			
			p1.fire(7, 2);
			System.out.println("player2's grid");
			g1.getGridPlayer2().displayEnemyGrid();
			
			p2.fire(4, 3);
			System.out.println("player1's grid");
			g1.getGridPlayer1().displayEnemyGrid();
			
			p1.fire(5, 5);
			System.out.println("player2's grid");
			g1.getGridPlayer2().displayEnemyGrid();
			
			p2.fire(2, 6);
			System.out.println("player1's grid");
			g1.getGridPlayer1().displayEnemyGrid();
						

		};
	}
}
