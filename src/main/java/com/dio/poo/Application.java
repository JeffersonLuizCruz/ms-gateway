package com.dio.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		
		return builder
				.routes()
				.route(r -> r.path("/customers/**").uri("lb://mscustomers"))
				.route(r -> r.path("/cards/**").uri("lb://mscards"))
				.route(r -> r.path("/evaluators/**").uri("lb://mscreditevaluator"))
				.build();
	}
}
