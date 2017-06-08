package com.maxoreau.springboot.bataillenavale;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Location;
import com.maxoreau.springboot.bataillenavale.models.Player;


@SpringBootApplication
public class BataillenavaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BataillenavaleApplication.class, args);
		Player p1 = new Player();
		p1.setName("p1");
		Player p2 = new Player();
		p2.setName("p2");

		Long debut = System.currentTimeMillis();
		Game g1 = p1.createGame();
		Long fin = System.currentTimeMillis();
		System.out.println("jeu généré en " + (fin - debut) + " millisecondes");
		p2.enterGame(g1);

		for (Location location : g1.getGridPlayer1().getLocations()) {
			if ((location.getCol() + 1) < g1.getGridPlayer1().getSize()) {
				switch (location.getNature()) {
				case BOAT:
					System.out.print(" X ");
					break;
				case WATER:
					System.out.print(" - ");
					break;
				}
			} else {
				switch (location.getNature()) {
				case BOAT:
					System.out.println(" X");
					break;
				case WATER:
					System.out.println(" -");
					break;
				}
			}
		}

		p1.fire(0, 0);
		p2.fire(0, 0);
		p1.fire(1, 1);
		p2.fire(2, 9);
		p1.fire(5, 5);
		p2.fire(2, 6);
		p1.fire(7, 2);
		p2.fire(4, 3);
		p1.fire(5, 5);
		p2.fire(2, 6);
		p1.fire(7, 2);
		p2.fire(4, 3);
		
		for (Location location : g1.getGridPlayer1().getLocations()) {
			if ((location.getCol() + 1) < g1.getGridPlayer1().getSize()) {
				switch (location.getNature()) {
				case BOAT:
					System.out.print(" X ");
					break;
				case WATER:
					System.out.print(" - ");
					break;
				}
			} else {
				switch (location.getNature()) {
				case BOAT:
					System.out.println(" X");
					break;
				case WATER:
					System.out.println(" -");
					break;
				}
			}
		}
		System.out.println("---------------------------------");
		for (Location location : g1.getGridPlayer1().getLocations()) {
			if ((location.getCol() + 1) < g1.getGridPlayer1().getSize()) {
				switch (location.getStatus()) {
				case UNDISCOVERED:
					System.out.print(" - ");
					break;
				case DISCOVERED:
					System.out.print(" O ");
					break;
				}
			} else {
				switch (location.getStatus()) {
				case UNDISCOVERED:
					System.out.println(" -");
					break;
				case DISCOVERED:
					System.out.println(" O");
					break;
				}
			}
		}
	}
}
