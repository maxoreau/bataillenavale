package com.maxoreau.springboot.bataillenavale.models;

//import javax.persistence.Entity;
//
//@Entity
public class Location {
	public enum LocationStatus {DISCOVERED, UNDISCOVERED}

	private Long id;
	private int x;
	private int y;
	private LocationStatus status;
	private Boat boat;

	public Location() {
		status = LocationStatus.UNDISCOVERED;
		boat = null;
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

	public LocationStatus getStatus() {
		return status;
	}

	public void setStatus(LocationStatus status) {
		this.status = status;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", x=" + x + ", y=" + y + ", status=" + status + ", boat=" + boat + "]";
	}
	

}
