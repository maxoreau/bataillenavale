package com.maxoreau.springboot.bataillenavale.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.maxoreau.springboot.bataillenavale.models.Boat;
import com.maxoreau.springboot.bataillenavale.models.Boat.Orientation;
import com.maxoreau.springboot.bataillenavale.models.Game;

public class BoatFactory {

	private static BoatFactory boatFactory;

	public BoatFactory() {
		super();
	}

	public static BoatFactory getBateauFactory() {
		if (boatFactory == null) {
			boatFactory = new BoatFactory();
		}
		return boatFactory;
	}

	public Boat createBoat(Game game) {
		Boat boat = new Boat();
		boolean overlap = true;
		while (overlap) {
			int rnd = ThreadLocalRandom.current().nextInt(0, 2);
			Orientation orientation;
			
			if (rnd == 0) {
				orientation = Orientation.HORIZONTAL;
				
			} else {
				orientation = Orientation.VERTICAL;
			}
			
			boat.setOrientation(orientation);
			if (boat.getOrientation().compareTo(Orientation.HORIZONTAL) == 0) { // si horizontal
			}

		}

		return boat;
	}

}
