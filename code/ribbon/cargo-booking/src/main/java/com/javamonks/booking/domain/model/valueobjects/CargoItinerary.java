package com.javamonks.booking.domain.model.valueobjects;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Embeddable
public class CargoItinerary {

	public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cargo_id")
	private List<Leg> legs = Collections.emptyList();

	public CargoItinerary() {
		// Nothing to initialize.
	}

	public CargoItinerary(List<Leg> legs) {
		this.legs = legs;
	}

	public List<Leg> getLegs() {
		return Collections.unmodifiableList(legs);
	}
}
