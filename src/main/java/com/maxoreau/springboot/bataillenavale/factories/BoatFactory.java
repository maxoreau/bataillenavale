package com.maxoreau.springboot.bataillenavale.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.maxoreau.springboot.bataillenavale.models.Boat;
import com.maxoreau.springboot.bataillenavale.models.Boat.Orientation;
import com.maxoreau.springboot.bataillenavale.models.Grid;

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

	public Boat createBoat(Grid grid) {
		
		Boat boat = new Boat();
		boolean overlap = true;
		while (overlap) {
			int rnd = ThreadLocalRandom.current().nextInt(0, 2);			
			if (rnd == 0) {
				boat.setOrientation(Orientation.HORIZONTAL);
				boat.setX(ThreadLocalRandom.current().nextInt(0, (grid.getSize()+1-boat.getSize())));
				boat.setY(ThreadLocalRandom.current().nextInt(0, (grid.getSize()+1)));
				
			} else {
				boat.setOrientation(Orientation.VERTICAL);
				boat.setX(ThreadLocalRandom.current().nextInt(0, (grid.getSize()+1)));
				boat.setY(ThreadLocalRandom.current().nextInt(0, (grid.getSize()+1-boat.getSize())));
			}
			
		}

		return boat;
	}

}
