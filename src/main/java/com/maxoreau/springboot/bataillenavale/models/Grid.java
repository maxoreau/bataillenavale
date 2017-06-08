package com.maxoreau.springboot.bataillenavale.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.maxoreau.springboot.bataillenavale.models.Location.LocationStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Grid implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int size;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Location> locations;

	@OneToMany(cascade = CascadeType.ALL)
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

	public void displayEnemyGrid() {
		
//		for (Location loc : this.locations) {
//			System.out.println(loc.getCol());
//		}
		
		String border = "##";
		
		for (int col = 0; col < this.size; col++) {
			border += "###";
		}
		
		System.out.println(border);

		for (Location location : this.locations) {
			if (location.getCol() == 0) {
				switch (location.getStatus()) {
				case UNDISCOVERED:
					System.out.print("#   ");
					break;
				case DISCOVERED:
					switch (location.getNature()) {
					case BOAT:
						System.out.print("# X ");
						break;
					case WATER:
						System.out.print("# - ");
						break;
					}
					break;
				}
				
			} else if ((location.getCol() > 0) && (location.getCol() < (this.size - 1))) {
				switch (location.getStatus()) {
				case UNDISCOVERED:
					System.out.print("   ");
					break;
				case DISCOVERED:
					switch (location.getNature()) {
					case BOAT:
						System.out.print(" X ");
						break;
					case WATER:
						System.out.print(" - ");
						break;
					}
					break;
				}
			} else {
				switch (location.getStatus()) {
				case UNDISCOVERED:
					System.out.println("   #");
					break;
				case DISCOVERED:
					switch (location.getNature()) {
					case BOAT:
						System.out.println(" X #");
						break;
					case WATER:
						System.out.println(" - #");
						break;
					}
					break;
				}
			}
		}
		
		System.out.println(border);
	}

	public int convertCoordToIndex(int col, int row) {
		return ((row * size) + col);
	}
}