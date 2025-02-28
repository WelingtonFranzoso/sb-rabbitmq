package com.franzoso;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SbApiRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbApiRabbitmqApplication.class, args);
	}

}
