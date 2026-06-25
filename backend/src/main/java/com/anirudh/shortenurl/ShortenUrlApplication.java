package com.anirudh.shortenurl;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class ShortenUrlApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ShortenUrlApplication.class, args);
	}

}
