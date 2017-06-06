package com.maxoreau.springboot.bataillenavale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maxoreau.springboot.bataillenavale.models.Player;


@SpringBootApplication
public class BataillenavaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BataillenavaleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (){
		return (args) -> {
			Player j1 = new Player();
			j1.createGame();
			
		};
	}
}
