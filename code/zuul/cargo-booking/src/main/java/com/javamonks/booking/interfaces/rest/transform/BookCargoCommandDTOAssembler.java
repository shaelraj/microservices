package com.javamonks.booking.interfaces.rest.transform;

import com.javamonks.booking.domain.model.commands.BookCargoCommand;
import com.javamonks.booking.interfaces.rest.dto.BookCargoResource;

/**
 * Assembler class to convert the Book Cargo Resource Data to the Book Cargo Model
 */
public class BookCargoCommandDTOAssembler {

    /**
     * Static method within the Assembler class
     * @param bookCargoResource
     * @return BookCargoCommand Model
     */
    public static BookCargoCommand toCommandFromDTO(BookCargoResource bookCargoResource){

        return new BookCargoCommand(
                                    bookCargoResource.getBookingAmount(),
                                    bookCargoResource.getOriginLocation(),
                                    bookCargoResource.getDestLocation(),
                                    java.sql.Date.valueOf(bookCargoResource.getDestArrivalDeadline()));
    }
}
