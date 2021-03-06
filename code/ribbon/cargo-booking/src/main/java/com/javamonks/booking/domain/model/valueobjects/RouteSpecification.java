package com.javamonks.booking.domain.model.valueobjects;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.javamonks.booking.domain.model.entities.Location;

@Embeddable
public class RouteSpecification {
	private static final long serialVersionUID = 1L;
	@Embedded
	@AttributeOverride(name = "unLocCode", column = @Column(name = "spec_origin_id"))
	private Location origin;
	@Embedded
	@AttributeOverride(name = "unLocCode", column = @Column(name = "spec_destination_id"))
	private Location destination;
	@Temporal(TemporalType.DATE)
	@Column(name = "spec_arrival_deadline")
	@NotNull
	private Date arrivalDeadline;

	public RouteSpecification() {
	}

	/**
	 * @param origin          origin location - can't be the same as the destination
	 * @param destination     destination location - can't be the same as the origin
	 * @param arrivalDeadline arrival deadline
	 */
	public RouteSpecification(Location origin, Location destination, Date arrivalDeadline) {

		this.origin = origin;
		this.destination = destination;
		this.arrivalDeadline = (Date) arrivalDeadline.clone();
	}

	public Location getOrigin() {
		return origin;
	}

	public Location getDestination() {
		return destination;
	}

	public Date getArrivalDeadline() {
		return new Date(arrivalDeadline.getTime());
	}

}
