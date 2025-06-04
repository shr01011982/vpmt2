package com.v2soft.vpmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class VpmtApplication {
	private static final Logger logger = LoggerFactory.getLogger(VpmtApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VpmtApplication.class, args);
		logger.info("Role Permission Microservice started successfully.");
	}

}
