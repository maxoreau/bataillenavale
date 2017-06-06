package com.maxoreau.springboot.bataillenavale.models;

import java.util.List;

public class Joueur {

	private Long id;
	private String nom;
	private List<Partie> partiesEnCours;
	private int partiesGagnees;

	public Joueur() {
		partiesEnCours = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Partie> getPartiesEnCours() {
		return partiesEnCours;
	}

	public void setPartiesEnCours(List<Partie> partiesEnCours) {
		this.partiesEnCours = partiesEnCours;
	}

	public int getPartiesGagnees() {
		return partiesGagnees;
	}

	public void setPartiesGagnees(int partiesGagnees) {
		this.partiesGagnees = partiesGagnees;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", partiesEnCours=" + partiesEnCours + ", partiesGagnees="
				+ partiesGagnees + "]";
	}
	
	public void tirer(int x, int y){
		
	}
	
	

}
