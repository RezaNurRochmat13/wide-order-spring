package com.wide.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WideOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WideOrderApplication.class, args);
	}

}
