package com.javamonks.mdmconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(Source.class)
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	@StreamListener("helloinchannel")
	public void processGreeting(Greeting greeting) {
		System.err.println("Recevied Greeting  with message ===="+greeting.getMessage());
			
	}

}
