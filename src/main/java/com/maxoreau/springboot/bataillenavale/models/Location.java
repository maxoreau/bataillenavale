package com.maxoreau.springboot.bataillenavale.models;

import javax.persistence.Entity;

@Entity
public class Location {
	public enum StatutCase {DISCOVERED, UNDISCOVERED}

	private Long id;
	private int x;
	private int y;
	private StatutCase statut;
	private Boat bateau;

	public Location() {
		statut = StatutCase.UNDISCOVERED;
		bateau = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public StatutCase getStatut() {
		return statut;
	}

	public void setStatut(StatutCase statut) {
		this.statut = statut;
	}


	public Boat getBateau() {
		return bateau;
	}

	public void setBateau(Boat bateau) {
		this.bateau = bateau;
	}

	@Override
	public String toString() {
		return "Case [id=" + id + ", x=" + x + ", y=" + y + ", statut=" + statut + "]";
	}
	

}
