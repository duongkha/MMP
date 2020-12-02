package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Airline;
import models.Flight;

import org.junit.jupiter.api.BeforeAll;

public class AirlineTest {
	private static Airline airline;
	
	@BeforeAll
	public static void setUp() {
		airline = new Airline("002", "AE", "American Eagle", "Very Good history");
	}
	@Test
	public void testGetAirlineId() {
		var output = airline.getAirlineId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("002", output);
	}
	@Test
	public void testGetCode() {
		var output = airline.getCode();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("AE", output);
	}
	@Test
	public void testGetName() {
		var output = airline.getName();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("American Eagle", output);
	}
	@Test
	public void testGetHistory() {
		var output = airline.getHistory();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Very Good history", output);
	}
	@Test
	public void testGetFlights() {
		var output  = airline.getFlights();
		Assertions.assertNotNull(output);
		for (var v:output) {
			Assertions.assertTrue(v instanceof Flight);
		}
	}
}
