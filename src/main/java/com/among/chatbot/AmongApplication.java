package com.among.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author botaruibo
 */
@SpringBootApplication
public class AmongApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AmongApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AmongApplication.class, args);
	}

}
