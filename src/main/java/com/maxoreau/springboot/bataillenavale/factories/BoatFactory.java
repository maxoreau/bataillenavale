package com.maxoreau.springboot.bataillenavale.factories;

import com.maxoreau.springboot.bataillenavale.models.Boat;

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

	public Boat getBoat() {
		Boat boat = new Boat();
		
		
		return boat;
	}
	
	

}
