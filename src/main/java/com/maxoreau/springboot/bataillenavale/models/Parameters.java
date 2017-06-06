package com.maxoreau.springboot.bataillenavale.models;

public class Parameters {
	
	private static int nbMoves = 60;
	private static int gridSize = 10;
	
	public Parameters() {
		super();		
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

	@Override
	public String toString() {
		return "Parameters []";
	}
	

}
