package com.maxoreau.springboot.bataillenavale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	public enum LocationStatus {DISCOVERED, UNDISCOVERED}
	public enum LocationNature {WATER, BOAT}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int col;
	private int row;
	private LocationStatus status;
	private LocationNature nature;
	private Boat boat;

	public Location() {
		status = LocationStatus.UNDISCOVERED;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public LocationStatus getStatus() {
		return status;
	}

	public void setStatus(LocationStatus status) {
		this.status = status;
	}

	public LocationNature getNature() {
		return nature;
	}

	public void setNature(LocationNature nature) {
		this.nature = nature;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", col=" + col + ", row=" + row + ", status=" + status + ", nature=" + nature
				+ ", boat=" + boat + "]";
	}
	

}
