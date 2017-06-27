package com.maxoreau.springboot.bataillenavale;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.maxoreau.springboot.bataillenavale"})
@EntityScan({"com.maxoreau.springboot.bataillenavale.models"})
public class ConfigurationJPA {
	

}
