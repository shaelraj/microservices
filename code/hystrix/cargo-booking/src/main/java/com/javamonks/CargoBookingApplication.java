package com.javamonks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.javamonks.booking.infrastructure.infrastructure.brokers.CargoEventSource;

@SpringBootApplication
@EnableBinding(CargoEventSource.class)
@EnableDiscoveryClient
@EnableHystrix
public class CargoBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoBookingApplication.class, args);
	}
	
	@Bean
	 @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
