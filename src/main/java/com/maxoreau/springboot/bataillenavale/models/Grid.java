package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.persistence.Entity;
//
//@Entity
public class Grid {

	private Long id;
	private int size;
	private Location[][] loctions;
	private List<Boat> boats;

	public Grid() {
		size = Parameters.getGridSize();
		loctions = new Location[size][size];
		boats = new ArrayList<>();
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

	public Location[][] getLoctions() {
		return loctions;
	}

	public void setLoctions(Location[][] loctions) {
		this.loctions = loctions;
	}

	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}

	@Override
	public String toString() {
		return "Grid [id=" + id + ", size=" + size + ", loctions=" + Arrays.toString(loctions) + ", boats=" + boats
				+ "]";
	}
}