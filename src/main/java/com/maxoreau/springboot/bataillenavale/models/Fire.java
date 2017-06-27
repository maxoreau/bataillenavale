package com.maxoreau.springboot.bataillenavale.models;

public class Fire {
	
	private int col;
	private int row;
	private Player player;
	
	public Fire() {
		super();
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Fire [col=" + col + ", row=" + row + ", player=" + player + "]";
	}

}
