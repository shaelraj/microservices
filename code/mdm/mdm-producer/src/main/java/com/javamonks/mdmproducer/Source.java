package com.javamonks.mdmproducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
	@Output("hellooutchannel")
	MessageChannel myoutput();
}

