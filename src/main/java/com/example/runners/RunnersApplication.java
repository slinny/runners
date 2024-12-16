package com.example.runners;

import com.example.runners.run.Location;
import com.example.runners.run.Run;
import com.example.runners.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnersApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
		log.info("changed message");
	}

	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1,"Run", LocalDateTime.now(),LocalDateTime.now().plus(6, ChronoUnit.MINUTES),1, Location.OUTDOOR);
			runRepository.create(run);
			log.info("Run: " + run);
		};
	}

}
