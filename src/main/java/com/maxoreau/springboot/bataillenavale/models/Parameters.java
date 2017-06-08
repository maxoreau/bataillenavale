package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Parameters implements Serializable {
		
	
	private static final long serialVersionUID = 1L;
	
	
	private static int nbMoves = 10;
	private static int gridSize = 10;
	private static List<Integer> boatSizes = new ArrayList<>();
	
	static {
		boatSizes.add(5);
		boatSizes.add(4);
		boatSizes.add(3);
		boatSizes.add(3);
		boatSizes.add(2);
	}
	

	public static int getNbMoves() {
		return nbMoves;
	}

	public static void setNbMoves(int nbMoves) {
		Parameters.nbMoves = nbMoves;
	}

	public static int getGridSize() {
		return gridSize;
	}

	public static void setGridSize(int gridSize) {
		Parameters.gridSize = gridSize;
	}

	public static List<Integer> getBoatSizes() {
		return boatSizes;
	}

	public static void setBoatSizes(List<Integer> boatSizes) {
		Parameters.boatSizes = boatSizes;
	}
	

}
