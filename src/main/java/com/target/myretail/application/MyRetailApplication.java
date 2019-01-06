package com.target.myretail.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/*
 * MyRetail application provides apis to search for different 
 * products and the corresponding price and descriptions.
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("com.target.myretail.repositories")
@EnableMongoRepositories("com.target.myretail.repositories")
@ComponentScan(basePackages = "com.target.myretail")
@EntityScan(basePackages = "com.target.myretail.models")
public class MyRetailApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MyRetailApplication.class);

	public static void main(String[] args) {
		logger.info("Starting the MyRetail service");
		SpringApplication.run(MyRetailApplication.class, args);
	}

}

