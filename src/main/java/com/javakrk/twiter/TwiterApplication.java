package com.javakrk.twiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwiterApplication.class, args);
		System.out.println("Hello");
	}

}
