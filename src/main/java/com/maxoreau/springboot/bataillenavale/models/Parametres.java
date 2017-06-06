package com.maxoreau.springboot.bataillenavale.models;

public class Parametres {
	
	private static int nombreDeTours = 60;
	private static int tailleCarte = 10;
	
	public Parametres() {
		
	}

	public static int getNombreDeTours() {
		return nombreDeTours;
	}

	public static void setNombreDeTours(int nbTours) {
		nombreDeTours = nbTours;
	}

	public static int getTailleCarte() {
		return tailleCarte;
	}

	public static void setTailleCarte(int taille) {
		tailleCarte = taille;
	}

	@Override
	public String toString() {
		return "Parametres [nombreDeTours=" + nombreDeTours + ", tailleCarte=" + tailleCarte + "]";
	}
	

}
