package com.javamonks.routing.domain.model.aggregates;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import com.javamonks.routing.domain.model.valueobjects.Schedule;
import com.javamonks.routing.domain.model.valueobjects.VoyageNumber;

@Entity
@NamedQueries({
		@NamedQuery(name = "Voyage.findByVoyageNumber", query = "Select v from Voyage v where v.voyageNumber = :voyageNumber"),
		@NamedQuery(name = "Voyage.findAll", query = "Select v from Voyage v order by v.voyageNumber") })
public class Voyage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	@NotNull
	private Schedule schedule;

	@Embedded
	private VoyageNumber voyageNumber;

	public Voyage() {
	}

	public Voyage(VoyageNumber voyageNumber, Schedule schedule) {
		this.schedule = schedule;
		this.voyageNumber = voyageNumber;
	}

	public VoyageNumber getVoyageNumber() {
		return voyageNumber;
	}

	public Schedule getSchedule() {
		return schedule;
	}

}
