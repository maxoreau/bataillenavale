package com.maxoreau.springboot.bataillenavale.factories;

import com.maxoreau.springboot.bataillenavale.models.Bateau;

public class BateauFactory {
	
	private static BateauFactory bateauFactory;
	
	public BateauFactory() {
		super();
	}

	public static BateauFactory getBateauFactory() {
		if (bateauFactory == null) {
			bateauFactory = new BateauFactory();
		}
		return bateauFactory;
	}

	public Bateau getBateau() {
		Bateau bateau = new Bateau();
		
		
		return bateau;
	}
	
	

}
