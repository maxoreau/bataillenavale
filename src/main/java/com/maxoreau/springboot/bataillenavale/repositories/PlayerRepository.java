package com.maxoreau.springboot.bataillenavale.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maxoreau.springboot.bataillenavale.models.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	List<Player> findByName (String name);

}
