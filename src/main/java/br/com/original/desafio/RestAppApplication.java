package br.com.original.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}

}
