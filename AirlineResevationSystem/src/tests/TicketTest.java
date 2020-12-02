package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import models.Address;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;
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
		List<FlightInstance> flightInstanceList = new ArrayList<>();
		flightInstanceList.add(flightInstance);
		Reservation reservation = new Reservation("0091", flightInstanceList, "99", 
				new Passenger("065", "John", "Doe", LocalDate.of(1990, 10, 10), "john@doe.com"));
		ticket = new Ticket(flightInstance, reservation);	
	}
	@Test
	public void testGetTicketId() {
		var output = ticket.getTicketId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
	}
	@Test
	public void testGetTicketNumber() {
		var output = ticket.getTicketNumber();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
	}
	@Test
	public void testGetFlightInstance() {
		var output = ticket.getFlightInstance();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof FlightInstance);
	}
	@Test
	public void testGetReservation() {
		var output =ticket.getReservation();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Reservation);
	}
}
