package com.javamonks.booking.domain.model.valueobjects;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.javamonks.booking.domain.model.entities.Location;

@Entity
public class Leg {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private Voyage voyage;
	@Embedded
	@AttributeOverride(name = "unLocCode", column = @Column(name = "load_location_id"))
	private Location loadLocation;
	@Embedded
	@AttributeOverride(name = "unLocCode", column = @Column(name = "unload_location_id"))
	private Location unloadLocation;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "load_time")
	@NotNull
	private Date loadTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "unload_time")
	@NotNull
	private Date unloadTime;

	public Leg() {
	}

	public Leg(Voyage voyage, Location loadLocation, Location unloadLocation, Date loadTime, Date unloadTime) {
		this.voyage = voyage;
		this.loadLocation = loadLocation;
		this.unloadLocation = unloadLocation;
		this.loadTime = loadTime;
		this.unloadTime = unloadTime;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public Location getLoadLocation() {
		return loadLocation;
	}

	public void setLoadLocation(Location loadLocation) {
		this.loadLocation = loadLocation;
	}

	public Location getUnloadLocation() {
		return unloadLocation;
	}

	public void setUnloadLocation(Location unloadLocation) {
		this.unloadLocation = unloadLocation;
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	public Date getUnloadTime() {
		return unloadTime;
	}

	public void setUnloadTime(Date unloadTime) {
		this.unloadTime = unloadTime;
	}

}
