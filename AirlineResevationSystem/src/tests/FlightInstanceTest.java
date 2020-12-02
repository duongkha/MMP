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

public class FlightInstanceTest {
	private static FlightInstance flightInstance;
	
	@BeforeAll
	public static void setUp() {
		Flight flight = new Flight(LocalTime.of(12, 05), 
				LocalTime.of(13, 05), "FL980", 65,
				new Airport("004", "CID", "Cedar Rapids Airport", 
					new Address("78", "2121 Aurthur Collins Parkway SW", "Cedar Rapids","Iowa",  "52404")),
				new Airport("007", "OIA", "O'hare International Airport",
					new Address("45", "10000 Ohare ave", "Chicago","Illinios",  "60666")),
				new Airline("002", "AE", "American Eagle", "Very Good history"));
		flightInstance = new FlightInstance(flight, "FN678", LocalDate.now());
		List<String> pilots = new ArrayList<>();
		pilots.add("John");
		flightInstance.setPilots(pilots);
		flightInstance.setCrews(pilots);
	}
	
	@Test
	public void testGetFlight() {
		var output = flightInstance.getFlight();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Flight);
	}
	@Test
	public void testGetDate() {
		var output = flightInstance.getDate();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof LocalDate);
	}
	@Test
	public void testGetId() {
		var output = flightInstance.getId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("FN678", output);
	}
	@Test
	public void testGetCrews() {
		var output = flightInstance.getCrews();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
	}
	@Test
	public void testGetPilots() {
		var output = flightInstance.getPilots();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
	}
}
