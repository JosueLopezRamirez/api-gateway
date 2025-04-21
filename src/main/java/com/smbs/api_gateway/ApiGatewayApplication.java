package com.smbs.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${attendance.service.url}") String attendanceServiceUrl,
			@Value("${auth.service.url}") String authServiceUrl
	){
		// added comments
		return builder
				.routes()
				.route(r -> r.path("/attendance-service/v3/api-docs").and().method(HttpMethod.GET).uri(attendanceServiceUrl))
				.route(r -> r.path("/api/v1/attendance/**")
						.and()
						.method(HttpMethod.GET,HttpMethod.POST,HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE)
						.uri(attendanceServiceUrl)
				)
				.route(r -> r.path("/auth-service/v3/api-docs").and().method(HttpMethod.GET).uri(authServiceUrl))
				.route(r -> r.path("/api/v1/auth/**")
						.and()
						.method(HttpMethod.GET,HttpMethod.POST,HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE)
						.uri(authServiceUrl)
				)
				.build();
	}

}
