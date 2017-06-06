package com.maxoreau.springboot.bataillenavale.models;

public class Case {

	private Long id;
	private int x;
	private int y;
	private StatutCase statut;
	private Bateau bateau;

	public Case() {
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


	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	@Override
	public String toString() {
		return "Case [id=" + id + ", x=" + x + ", y=" + y + ", statut=" + statut + "]";
	}
	

}
