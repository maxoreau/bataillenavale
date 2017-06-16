package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Boat implements Serializable {
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	public enum Orientation{HORIZONTAL, VERTICAL}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int size;
	@Enumerated(EnumType.STRING)
	private Orientation orientation;
	//coordinates of the top/left Location
	private int col;
	private int row;
	
	@Transient
	private Grid grid;
	
	@Transient
	private List<Location> positions = new ArrayList<>();
	
	public Boat() {
		super();
	}
	
	public Boat(int size) {
		super();
		this.size = size;
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

	public List<Location> getPositions() {
		return positions;
	}

	public void setPositions(List<Location> positions) {
		this.positions = positions;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Boat [id=" + id + ", size=" + size + ", orientation=" + orientation + ", col=" + col + ", row=" + row
				+ ", grid=" + grid + ", positions=" + positions + "]";
	}

}
