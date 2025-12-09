package com.turneo.agendadoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgendadocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadocApplication.class, args);
	}

}
