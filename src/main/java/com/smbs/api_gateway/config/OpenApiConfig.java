package com.smbs.api_gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservice Application",
                version = "1.0",
                contact = @Contact(
                        name = "Smbs Support Team",
                        url = "http://example.com",
                        email = "support@smbssolutions.com"
                ),
                description = "API documentation for the Microservice Application used to illustrate microservices deployment on AWS EKS.",
                termsOfService = "Terms of service: Use this API under the provided conditions as outlined in our documentation."
        )
)
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
    }
}
