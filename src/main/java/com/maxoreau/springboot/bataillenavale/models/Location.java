package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Location implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	public enum LocationStatus {DISCOVERED, UNDISCOVERED}
	public enum LocationNature {WATER, BOAT}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int col;
	private int row;
	
	@Enumerated(EnumType.STRING)
	private LocationStatus status;
	@Enumerated(EnumType.STRING)
	private LocationNature nature;
	
	@OneToOne
	private Boat boat;
	
	@Transient
	private Grid grid;

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

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", col=" + col + ", row=" + row + ", status=" + status + ", nature=" + nature
				+ ", boat=" + boat + ", grid=" + grid + "]";
	}
	

}
