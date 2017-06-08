package com.maxoreau.springboot.bataillenavale.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maxoreau.springboot.bataillenavale.models.Game;
import com.maxoreau.springboot.bataillenavale.models.Player;

public interface GameRepository extends CrudRepository<Game, Long> {
	
	List<Game> findByStatus(String status);
	List<Game> findByWinner(Player player);


}
