package tests;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Address;
import models.Airline;
import models.Airport;
import models.Flight;

public class FlightTest {
	private static Flight flight;

	@BeforeAll
	public static void setUp() {
		flight = new Flight(LocalTime.of(12, 05), 
				LocalTime.of(13, 05), "FL980", 65,
				new Airport("004", "CID", "Cedar Rapids Airport", 
					new Address("78", "2121 Aurthur Collins Parkway SW", "Cedar Rapids", "Iowa", "52404")),
				new Airport("007", "OIA", "O'hare International Airport",
					new Address("45", "10000 Ohare ave", "Chicago", "Illinios", "60666")),
				new Airline("002", "AE", "American Eagle", "Very Good history"));
	}
	@Test
	public void testGetFlightId() {
		var output = flight.getFlightId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("FL980", output);
	}
	@Test
	public void testGetDepartureTime() {
		var output = flight.getDepartureTime();
		Assertions.assertNotNull(output);
		Assertions.assertEquals(LocalTime.of(12, 05), output);
	}
	@Test
	public void testGetArrivalTime() {
		var output = flight.getArrivalTime();
		Assertions.assertNotNull(output);
		Assertions.assertEquals(LocalTime.of(13, 05), output);
	}
	@Test
	public void testGetCapacity() {
		var output = flight.getCapacity();
		Assertions.assertNotNull(output);
		Assertions.assertEquals(65, output);
	}	
	@Test
	public void testGetArrivalAirport() {
		var output = flight.getArrivalAirport();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Airport);
	}
	@Test
	public void testGetDepartureAirport() {
		var output = flight.getDepartureAirport();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Airport);
	}
	@Test
	public void testGetAirline() {
		var output = flight.getAirline();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Airline);
	}
}
