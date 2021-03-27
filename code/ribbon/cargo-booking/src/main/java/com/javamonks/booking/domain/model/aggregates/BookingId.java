package com.javamonks.booking.domain.model.aggregates;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Aggregate Identifier for the Cargo Aggregate
 */
@Embeddable
public class BookingId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -624546509528168070L;
	@Column(name="booking_id",length = 500)
    private String bookingId;

    public BookingId(){}

    public BookingId(String bookingId){this.bookingId = bookingId;}

    public String getBookingId(){return this.bookingId;}
}
