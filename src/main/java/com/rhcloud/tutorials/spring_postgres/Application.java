package com.rhcloud.tutorials.spring_postgres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(DiscordUserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new DiscordUser("user1", "Token1"));
			repository.save(new DiscordUser("user2", "Token2"));
			repository.save(new DiscordUser("user3", "Token3"));
			repository.save(new DiscordUser("user4", "Token4"));
			repository.save(new DiscordUser("user5", "Token5"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (DiscordUser user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			DiscordUser customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByUsername('user4'):");
			log.info("--------------------------------------------");
			for (DiscordUser bauer : repository.findByUsername("user4")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}