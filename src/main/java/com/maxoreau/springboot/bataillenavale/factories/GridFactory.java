package com.maxoreau.springboot.bataillenavale.factories;

import com.maxoreau.springboot.bataillenavale.models.Boat;
import com.maxoreau.springboot.bataillenavale.models.Grid;
import com.maxoreau.springboot.bataillenavale.models.Location;
import com.maxoreau.springboot.bataillenavale.models.Location.LocationNature;
import com.maxoreau.springboot.bataillenavale.models.Location.LocationStatus;
import com.maxoreau.springboot.bataillenavale.models.Parameters;

public class GridFactory {

	private static GridFactory gridFactory;

	public GridFactory() {
		super();
	}

	public static GridFactory getGridFactory() {
		if (gridFactory == null) {
			gridFactory = new GridFactory();
		}
		return gridFactory;
	}

	public Grid createGrid() {
		// instanciation de la grille puis initialisation des locations ( x, y, UNDISCOVERED, WATER)
		Grid grid = new Grid();
		initializeLocations(grid);
		
		
		//on creer autant de bateaux qu'il faut
		for (int i = 0; i < Parameters.getBoatSizes().size(); i++) {
			int size = Parameters.getBoatSizes().get(i).intValue();
			boolean added = false;
			
			do {
				// LA BOATFACTORY NOUS RENVOIE UN BATEAU ALEATOIRE
				Boat boat = BoatFactory.getBateauFactory().createBoat(grid, size);
				
				// ON VERIFIE SI IL N'Y A PAS D'OVERLAP
				if (doesNotOverlap(grid, boat)) {
					
					// SI PAS D'OVERLAP : ON MODIFIE LES LOCATIONS SUR LESQUELLES LE BATEAU SE TROUVE
					for (Location boatPosition : boat.getPositions()) {
						grid.getLocations().get(grid.convertCoordToIndex(boatPosition.getCol(), boatPosition.getRow())).setNature(LocationNature.BOAT);
						grid.getLocations().get(grid.convertCoordToIndex(boatPosition.getCol(), boatPosition.getRow())).setBoat(boat);
					}
					grid.getBoats().add(boat);
					added = true;
				}
				
			} while (!added);
		}
		for (Boat boat : grid.getBoats()) {
			grid.setLife((grid.getLife() + boat.getSize()));
		}

		return grid;
	}

	// on attribue les valeurs de x et y aux cases de la grille
	public void initializeLocations(Grid grid) {
		
		for (int row = 0; row < grid.getSize(); row++) {
			for (int col = 0; col < grid.getSize(); col++) {
				Location location = new Location();
				location.setCol(col);
				location.setRow(row);
				location.setNature(LocationNature.WATER);
				location.setStatus(LocationStatus.UNDISCOVERED);
				grid.getLocations().add(location);
			}
		}
	}

	public boolean doesNotOverlap (Grid grid, Boat boat) {
		
		for (Location boatPosition : boat.getPositions()) {
			if (grid.getLocations().get(grid.convertCoordToIndex(boatPosition.getCol(), boatPosition.getRow())).getNature().compareTo(LocationNature.BOAT) == 0) {
				return false;
			}
		}
		
//		for (Location position : boat.getPositions()) {
//			for (Boat existingBoat : grid.getBoats()) {
//				for (Location existingPosition : existingBoat.getPositions()) {
//					if ((existingPosition.getCol() == position.getCol()) && (existingPosition.getRow() == position.getRow())) {
//						return false;
//					}
//				}
//			}
//		}
		
		return true;
	}

}
