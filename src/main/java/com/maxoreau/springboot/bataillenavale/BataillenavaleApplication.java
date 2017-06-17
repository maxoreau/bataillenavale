package com.maxoreau.springboot.bataillenavale;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Game.GameStatus;
import com.maxoreau.springboot.bataillenavale.models.GameManager;
import com.maxoreau.springboot.bataillenavale.models.Parameters;
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

			Game g = playerRepo.findByName("bob").get(0).createGame();
			
			playerRepo.save(playerRepo.findByName("bob").get(0));
			
			playerRepo.findByName("ruth").get(0).enterGame(g);
			
			playerRepo.save(playerRepo.findByName("ruth").get(0));
			
			gameRepo.save(g);
			
			
			
			for (int i = 0; i < 15; i++) {				
					 int colA = ThreadLocalRandom.current().nextInt(0,
					 (Parameters.getGridSize()));
					 int rowA = ThreadLocalRandom.current().nextInt(0,
					 (Parameters.getGridSize()));
					 playerRepo.findByName("bob").get(0).fire(colA, rowA);
					 System.out.println("player2's grid");
					 g.getGridPlayer2().displayOwnGrid();
					
					 int colB = ThreadLocalRandom.current().nextInt(0,
					 (Parameters.getGridSize()));
					 int rowB = ThreadLocalRandom.current().nextInt(0,
					 (Parameters.getGridSize()));
					 playerRepo.findByName("ruth").get(0).fire(colB, rowB);
					 System.out.println("player1's grid");
					 g.getGridPlayer1().displayOwnGrid();
									
			}
		};
	}
}
			
			
//			 Player p1 = new Player();
//			 p1.setName("bob");
//			
//			 Player p2 = new Player();
//			 p2.setName("chuck");
//			 
//			 Player p3 = new Player();
//			 p3.setName("ruth");
//			
//			 Player p4 = new Player();
//			 p4.setName("koost");
//
//			 playerRepo.save(p1);
//			 playerRepo.save(p2);
//			 playerRepo.save(p3);
//			 playerRepo.save(p4);
//			 
//			 Long debut = System.currentTimeMillis();
//			 Game g1 = p1.createGame();
//			 Long fin = System.currentTimeMillis();
//			 gameRepo.save(g1);
//			 System.out.println("jeu généré en " + (fin - debut) + " millisecondes");
//			 p2.enterGame(g1);
//			 gameRepo.save(g1);	
//
//			
//			 do {
//			 int colA = ThreadLocalRandom.current().nextInt(0,
//			 (Parameters.getGridSize()));
//			 int rowA = ThreadLocalRandom.current().nextInt(0,
//			 (Parameters.getGridSize()));
//			 p1.fire(colA, rowA);
//			 System.out.println("player2's grid");
//			 g1.getGridPlayer2().displayOwnGrid();
//			
//			 int colB = ThreadLocalRandom.current().nextInt(0,
//			 (Parameters.getGridSize()));
//			 int rowB = ThreadLocalRandom.current().nextInt(0,
//			 (Parameters.getGridSize()));
//			 p2.fire(colB, rowB);
//			 System.out.println("player1's grid");
//			 g1.getGridPlayer1().displayOwnGrid();
//
//			 } while (g1.getStatus().compareTo(GameStatus.ONGOING) == 0);
//			 
//			 System.out.println("a");
//			 gameRepo.save(g1);
//			 System.out.println("b");
//			 
//			 playerRepo.save(p1);
//			 System.out.println("c");
//			 playerRepo.save(p2);
//			 System.out.println("d");
//			 
//			 Game g2 = p1.createGame();
//			 
//			 gameRepo.save(g2);
//			 
//			 playerRepo.save(p1);
//			 
//			
//
//		};
//	}
//}
