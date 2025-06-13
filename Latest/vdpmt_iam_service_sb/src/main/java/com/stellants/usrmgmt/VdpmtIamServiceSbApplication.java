package com.stellants.usrmgmt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Vehcile Diagnostic Program Management API",
				version = "1.0.0",
				description = "API to manage Vehcile Diagnostic Program Management",
				contact = @Contact(
						name = "Stellants Dev Team",
						email = "dev@stellants.com",
						url = "https://stellants.com"
				),
				license = @License(
						name = "Apache License 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				),
				termsOfService = "https://stellants.com/terms"
		),
		servers = {
				@Server(url = "http://localhost:8080", description = "Dev development server")
		}
)
public class VdpmtIamServiceSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(VdpmtIamServiceSbApplication.class, args);
	}

}
