package com.maxoreau.springboot.bataillenavale.models;

import java.util.ArrayList;
import java.util.List;

import com.maxoreau.springboot.bataillenavale.models.Location.LocationStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Grid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int size;
	
	@OneToMany
	private List<Location> locations;
	
	@OneToMany
	private List<Boat> boats;
	
	@OneToOne
	private Game game;

	public Grid() {
		size = Parameters.getGridSize();
		locations = new ArrayList<>();
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

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Grid [id=" + id + ", size=" + size + ", locations=" + locations + ", boats=" + boats + "]";
	}

//	public void createBoats(){
//		Boat boat = BoatFactory.getBateauFactory().createBoat(this);
//		boats.add(boat);
//	}
	
	public void fireManager(Fire fire) {
		Location firedLocation = locations.get(convertCoordToIndex(fire.getCol(), fire.getRow()));
		
		switch (firedLocation.getStatus()) {
		case DISCOVERED:
			// LA CASE A DEJA ETE TIREE. ON S'ARRETE LA
			break;

		case UNDISCOVERED:
			// LA CASE N'A PAS DEJA ETE VISEE 
			switch (firedLocation.getNature()) {
			case WATER:
				// PLOUF
				break;
			case BOAT:
				// BOOM
				// ON DECREMENTE LA VIE DU PLAYER AYANT RECU LE TIR
				if (fire.getPlayer().equals(game.getPlayer1())) {
					game.setPlayer2Life((game.getPlayer2Life() - 1));
				} else {
					game.setPlayer1Life((game.getPlayer1Life() - 1));
				}
				break;
			}

			firedLocation.setStatus(LocationStatus.DISCOVERED);
			break;
		}
	}
	
	public int convertCoordToIndex(int col, int row) {
		return ((row*size)+col);
	}
}