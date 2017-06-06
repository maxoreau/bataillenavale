package com.maxoreau.springboot.bataillenavale.models;

public class Parametres {
	
	private int nombreDeTours;
	private int tailleCarte;
	
	public Parametres() {
		// TODO Auto-generated constructor stub
	}

	public int getNombreDeTours() {
		return nombreDeTours;
	}

	public void setNombreDeTours(int nombreDeTours) {
		this.nombreDeTours = nombreDeTours;
	}

	public int getTailleCarte() {
		return tailleCarte;
	}

	public void setTailleCarte(int tailleCarte) {
		this.tailleCarte = tailleCarte;
	}

	@Override
	public String toString() {
		return "Parametres [nombreDeTours=" + nombreDeTours + ", tailleCarte=" + tailleCarte + "]";
	}
	

}
