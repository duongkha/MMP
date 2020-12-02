package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import models.Address;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Ticket;

public class TicketTest {
	private static Ticket ticket;
	
	@BeforeAll
	public static void setUp() {
		Flight flight = new Flight(LocalTime.of(12, 05), 
				LocalTime.of(13, 05), "FL980", 65,
				new Airport("004", "CID", "Cedar Rapids Airport", 
					new Address("78", "2121 Aurthur Collins Parkway SW", "Iowa", "Cedar Rapids", "52404")),
				new Airport("007", "OIA", "O'hare International Airport",
					new Address("45", "10000 Ohare ave", "Illinios", "Chicago", "60666")),
				new Airline("002", "AE", "American Eagle", "Very Good history"));
		FlightInstance flightInstance = new FlightInstance(flight, "FN678", LocalDate.now());
	}
}
