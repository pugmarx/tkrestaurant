package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.*;
import com.example.repos.*;

@SpringBootApplication
public class Solution implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestaurantJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Solution.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Restaurant id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.insert(new Restaurant(10010L, "Little Italy", "Italian")));

		logger.info("Update 10003 -> {}", repository.update(new Restaurant(10001L, "BBQ Nation", "Multiple")));

		repository.deleteById(10002L);

		logger.info("All restaurants -> {}", repository.findAll());
	}
}
