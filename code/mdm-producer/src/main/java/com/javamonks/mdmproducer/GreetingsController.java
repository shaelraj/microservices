/**
 * 
 */
package com.javamonks.mdmproducer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaelraj
 *
 */
@RestController
public class GreetingsController {
	
	private static Logger LOG = LogManager.getLogger(GreetingsController.class);

	@Autowired
	private Source source;

	@GetMapping("/greet")
	public Greeting createGreeting(String message) {
		
		Greeting greeting=new Greeting(message);
		LOG.info("Sending greeting!! ");
		
		source.myoutput().send(MessageBuilder.withPayload(greeting).build());
		
		return greeting;
		
	}
	

}
