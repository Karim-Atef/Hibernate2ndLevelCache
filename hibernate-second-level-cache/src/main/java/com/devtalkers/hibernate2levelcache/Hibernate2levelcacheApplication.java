package com.devtalkers.hibernate2levelcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Hibernate2levelcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hibernate2levelcacheApplication.class, args);
	}

}
