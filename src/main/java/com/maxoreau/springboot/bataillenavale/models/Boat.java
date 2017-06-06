package com.maxoreau.springboot.bataillenavale.models;

//import javax.persistence.Entity;
//
//@Entity
public class Boat {
	
	public enum Orientation{HORIZONTAL, VERTICAL}
	
	private Long id;
	private int size;
	private Orientation orientation;
	//coordinates of the top/left Location
	private int x;
	private int y;
	private int healthPoints; // correspond aux pv restants : taille - nb de tirs reçus
	
	public Boat() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
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

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	@Override
	public String toString() {
		return "Boat [id=" + id + ", size=" + size + ", orientation=" + orientation + ", x=" + x + ", y=" + y
				+ ", healthPoints=" + healthPoints + "]";
	}
	

}
