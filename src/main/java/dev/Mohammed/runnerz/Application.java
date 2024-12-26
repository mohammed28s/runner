package dev.Mohammed.runnerz;

import dev.Mohammed.runnerz.run.Location;
import dev.Mohammed.runnerz.run.Run;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class Application {

	private static final Logger log = getLogger(Application.class);

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			Run run = new Run(1,
					"First Run",
					LocalDateTime.now(),
					LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}
}
