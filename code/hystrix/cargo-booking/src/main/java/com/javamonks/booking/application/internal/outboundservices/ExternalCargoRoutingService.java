package com.javamonks.booking.application.internal.outboundservices;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamonks.booking.domain.model.entities.Location;
import com.javamonks.booking.domain.model.valueobjects.CargoItinerary;
import com.javamonks.booking.domain.model.valueobjects.Leg;
import com.javamonks.booking.domain.model.valueobjects.RouteSpecification;
import com.javamonks.booking.domain.model.valueobjects.Voyage;
import com.javamonks.shareddomain.model.TransitEdge;
import com.javamonks.shareddomain.model.TransitPath;

/**
 * Anti Corruption Service Class
 */
@Service
public class ExternalCargoRoutingService {
	
	
	@Autowired
	private CargoRoutingService cargoRoutingService;


    /**
     * The Booking Bounded Context makes an external call to the Routing Service of the Routing Bounded Context to
     * fetch the Optimal Itinerary for a Cargo based on the Route Specification
     * @param routeSpecification
     * @return
     */
	
	
	
	
	
    public CargoItinerary fetchRouteForSpecification(RouteSpecification routeSpecification){
    	
    	
 
    	 TransitPath transitPath =cargoRoutingService.findOptimalRoute(routeSpecification.getOrigin().getUnLocCode(), 
    			 routeSpecification.getDestination().getUnLocCode(), routeSpecification.getArrivalDeadline().toString());
    			 
    	
		
    	 return toCargoItenary(transitPath);

        

    }
    
  
    
    
    /**
     * Anti-corruption layer conversion method from the routing service's domain model (TransitPath and TransitEdges)
     * to the domain model recognized by the Booking Bounded Context (CargoItenary and Legs)
     * @param edge
     * @return
     */
    private CargoItinerary toCargoItenary(TransitPath transitPath) {
    	
    	List<Leg> legs = new ArrayList<Leg>();
    	if(transitPath.getTransitEdges().size()!=0) {
    		 for (TransitEdge edge : transitPath.getTransitEdges()) {
    	            legs.add(toLeg(edge));
    	        }

    	}
       
        return new CargoItinerary(legs);
    	
    }

  
    private Leg toLeg(TransitEdge edge) {
        return new Leg(
                new Voyage(edge.getVoyageNumber()),
                new Location(edge.getFromUnLocode()),
                new Location(edge.getToUnLocode()),
                edge.getFromDate(),
                edge.getToDate());
        }
}
