package com.maxoreau.springboot.bataillenavale.models;


public class Partie {
	
	private Long id;
	private StatutPartie statut;	// OUVERTE (attente d'un deuxieme joueur), ENCOURS, TERMINEE
	private Joueur joueurEnCours; 	// 1 pour joueur 1 et 2 pour joueur 2.
	private Joueur joueur1;
	private Joueur joueur2;
	private Carte carteJoueur1;
	private Carte carteJoueur2;
	private int toursRestants;
	private Joueur gagnant;
	
	public Partie() {
		statut = StatutPartie.OUVERTE;
		joueurEnCours = null;
		joueur1 = null;
		joueur2 = null;
		carteJoueur1 = null;
		carteJoueur2 = null;
		gagnant = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatutPartie getStatut() {
		return statut;
	}

	public void setStatut(StatutPartie statut) {
		this.statut = statut;
	}

	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public Carte getCarteJoueur1() {
		return carteJoueur1;
	}

	public void setCarteJoueur1(Carte carteJoueur1) {
		this.carteJoueur1 = carteJoueur1;
	}

	public Carte getCarteJoueur2() {
		return carteJoueur2;
	}

	public void setCarteJoueur2(Carte carteJoueur2) {
		this.carteJoueur2 = carteJoueur2;
	}

	public int getToursRestants() {
		return toursRestants;
	}

	public void setToursRestants(int toursRestants) {
		this.toursRestants = toursRestants;
	}

	public Joueur getGagnant() {
		return gagnant;
	}

	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", statut=" + statut + ", joueurEnCours=" + joueurEnCours + ", joueur1=" + joueur1
				+ ", joueur2=" + joueur2 + ", carteJoueur1=" + carteJoueur1 + ", carteJoueur2=" + carteJoueur2
				+ ", toursRestants=" + toursRestants + ", gagnant=" + gagnant + "]";
	}
	
	
}
