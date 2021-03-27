package com.javamonks.booking.application.internal.outboundservices;

import com.javamonks.shareddomain.model.TransitPath;

public interface CargoRoutingService {
	
	 public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) ;

}
