package com.maxoreau.springboot.bataillenavale.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.maxoreau.springboot.bataillenavale.models.Boat;
import com.maxoreau.springboot.bataillenavale.models.Boat.Orientation;
import com.maxoreau.springboot.bataillenavale.models.Grid;
import com.maxoreau.springboot.bataillenavale.models.Location;
import com.maxoreau.springboot.bataillenavale.models.Location.LocationNature;
import com.maxoreau.springboot.bataillenavale.models.Location.LocationStatus;



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

	public Boat createBoat(Grid grid, Integer size) {

		Boat boat = new Boat(size);

		int rnd = ThreadLocalRandom.current().nextInt(0, 2);
		if (rnd == 0) { 
			// on attribue une orientation horizontale au bateau
			boat.setOrientation(Orientation.HORIZONTAL);
			
			// on attribue aléatoirement les valeurs X et Y du bateau en fonction de la taille de la grille
			boat.setCol(ThreadLocalRandom.current().nextInt(0, (grid.getSize() - (boat.getSize() - 1))));
			boat.setRow(ThreadLocalRandom.current().nextInt(0, (grid.getSize())));
			
			// on remplit ensuite la liste des positions occupées par le bateau horizontal
			for (int i = 0; i < boat.getSize(); i++) {
				Location pos = new Location();
				pos.setCol((boat.getCol() + i));
				pos.setRow(boat.getRow());
				pos.setStatus(LocationStatus.UNDISCOVERED);
				pos.setNature(LocationNature.BOAT);
				pos.setBoat(boat);
				boat.getPositions().add(pos);
			}
						
		} else {
			// on attribue une orientation verticale au bateau
			boat.setOrientation(Orientation.VERTICAL);			

			// on attribue aléatoirement les valeurs X et Y du bateau en fonction de la taille de la grille
			boat.setCol(ThreadLocalRandom.current().nextInt(0, (grid.getSize())));
			boat.setRow(ThreadLocalRandom.current().nextInt(0, (grid.getSize() - (boat.getSize() - 1))));
			
			// on remplit ensuite la liste des positions occupées par le bateau vertical
			for (int i = 0; i < boat.getSize(); i++) {
				Location pos = new Location();
				pos.setRow((boat.getRow() + i));
				pos.setCol(boat.getCol());
				pos.setStatus(LocationStatus.UNDISCOVERED);
				pos.setNature(LocationNature.BOAT);
				pos.setBoat(boat);
				boat.getPositions().add(pos);
			}
		}
		
		return boat;
	}

}
