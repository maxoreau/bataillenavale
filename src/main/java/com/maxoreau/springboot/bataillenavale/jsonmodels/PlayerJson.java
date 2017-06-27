package com.maxoreau.springboot.bataillenavale.jsonmodels;

import com.maxoreau.springboot.bataillenavale.models.Player;

public class PlayerJson {
	
	private Long id;
	private String name;
	private int nbWins;
	
	public PlayerJson() {
	}
	
	public PlayerJson(Player player) {
		this(player.getId(), player.getName(), player.getNbWins());
	}


	public PlayerJson(Long id, String name, int nbWins) {
		this.id = id;
		this.name = name;
		this.nbWins = nbWins;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNbWins() {
		return nbWins;
	}


	public void setNbWins(int nbWins) {
		this.nbWins = nbWins;
	}


	@Override
	public String toString() {
		return "PlayerJson [id=" + id + ", name=" + name + ", nbWins=" + nbWins + "]";
	}
	
	

}
