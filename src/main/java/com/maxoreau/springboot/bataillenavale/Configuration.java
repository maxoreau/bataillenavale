package com.maxoreau.springboot.bataillenavale;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan({})
@EntityScan({"com.maxoreau.springboot.bataillenavale.models"})
public class Configuration {
	

}
