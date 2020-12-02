package tests;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Address;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;
import models.Ticket;

public class ReservationTest {
	private static Reservation reservation;
	@BeforeAll
	public static void SetUp() {
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
		reservation = new Reservation("0091", flightInstanceList, "99", 
				new Passenger("065", "John", "Doe", LocalDate.of(1990, 10, 10), "john@doe.com"));
	}
	
	@Test
	public void testGetTicket() {
		var output = reservation.getTickets();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof Ticket);
		}
	}
	@Test
	public void testGetFlightInstances() {
		var output = reservation.getFlightInstances();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof FlightInstance);
		}
	}
	@Test
	public void testGetReservationId() {
		var output = reservation.getReservationId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("0091", output);
	}
	@Test
	public void testGetAgentId() {
		var output = reservation.getAgentId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("99", output);
	}
	@Test
	public void testGetPassenger() {
		var output = reservation.getPassenger();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Passenger);
	}
}
