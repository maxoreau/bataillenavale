package com.maxoreau.springboot.bataillenavale.models;


public class Bateau {
	
	private Long id;
	private int taille;
	private int direction; // 0 = horizontal et 1 = vertical
	private int x;
	private int y;
	private int pointsDeVie;
	
	public Bateau() {
		// TODO Auto-generated constructor stub
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + ", taille=" + taille + ", direction=" + direction + ", x=" + x + ", y=" + y
				+ ", pointsDeVie=" + pointsDeVie + "]";
	}
	

}
