package com.zubrmobile.censure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CensureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensureApplication.class, args);
	}

}
