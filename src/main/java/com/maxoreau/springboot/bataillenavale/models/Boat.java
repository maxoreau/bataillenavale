package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boat {
	
	public enum Orientation{HORIZONTAL, VERTICAL}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int size;
	private Orientation orientation;
	//coordinates of the top/left Location
	private int col;
	private int row;
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

	@Override
	public String toString() {
		return "Boat [id=" + id + ", size=" + size + ", orientation=" + orientation + ", col=" + col + ", row=" + row
				+ ", positions=" + positions + "]";
	}
	

}
