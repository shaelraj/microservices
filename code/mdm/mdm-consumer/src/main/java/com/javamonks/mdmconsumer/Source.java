/**
 * 
 */
package com.javamonks.mdmconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author shaelraj
 *
 */
public interface Source {
	
	@Input("helloinchannel")
	SubscribableChannel myinput();
	
}
