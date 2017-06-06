package com.maxoreau.springboot.bataillenavale.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Carte {

	private Long id;
	private int taille;
	private List<Case> cases;

	public Carte() {
		taille = Parametres.getTailleCarte();
		cases = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		return "Carte [id=" + id + ", taille=" + taille + ", cases=" + cases + "]";
	}
	

}
