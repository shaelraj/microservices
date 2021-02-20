package com.javamonks.booking.interfaces.rest.transform;

import org.springframework.beans.factory.annotation.Autowired;

import com.javamonks.booking.application.internal.queryservices.CargoBookingQueryService;
import com.javamonks.booking.domain.model.commands.RouteCargoCommand;
import com.javamonks.booking.interfaces.rest.dto.RouteCargoResource;

/**
 * Assembler class to convert the Book Cargo Resource Data to the Book Cargo
 * Model
 */
public class RouteCargoCommandDTOAssembler {

	/**
	 * Static method within the Assembler class
	 * 
	 * @param routeCargoResource
	 * @return RouteCargoCommand Model
	 */

	@Autowired
	private CargoBookingQueryService cargoBookingQueryService;

	public static RouteCargoCommand toCommandFromDTO(RouteCargoResource routeCargoResource) {

		// Cargo cargo=cargoBookingQueryService.find(routeCargoResource.getBookingId());

		return new RouteCargoCommand(routeCargoResource.getBookingId());
	}
}
