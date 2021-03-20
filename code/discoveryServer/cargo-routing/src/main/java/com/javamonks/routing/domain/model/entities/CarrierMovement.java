package com.javamonks.routing.domain.model.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.javamonks.routing.domain.model.valueobjects.Location;

@Entity
@Table(name = "carrier_movement")
public class CarrierMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "arrival_date")
	private Date arrivalDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "departure_Date")
	private Date departureDate;
	@Embedded
	private Location arrivalLocation;
	@Embedded
	@AttributeOverride(name = "unLocCode", column = @Column(name = "departure_location_id"))
	private Location departureLocation;

	public CarrierMovement() {
	}

	public CarrierMovement(Location departureLocation, Location arrivalLocation, Date departureDate, Date arrivalDate) {

		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
	}

	public Location getDepartureLocation() {
		return departureLocation;
	}

	public Location getArrivalLocation() {
		return arrivalLocation;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

}
