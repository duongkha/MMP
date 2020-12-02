package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Address;
import models.Airport;
import models.Flight;


public class AirportTest {
	private static Airport airport; 
	
	@BeforeAll
	public static void setUp() {
		airport = new Airport("004", "CID", "Cedar Rapids Airport", 
				new Address("78", "2121 Aurthur Collins Parkway SW", "Cedar Rapids","Iowa",  "52404"));
	}
	@Test
	public void testGetAirportId() {
		var output = airport.getAirportId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("004", output);
	}
	@Test
	public void testGetCode() {
		var output = airport.getCode();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("CID", output);
	}
	@Test
	public void testGetName() {
		var output = airport.getName();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Cedar Rapids Airport", output);
	}
	@Test
	public void testGetAddress() {
		var output = airport.getAddress();
		Assertions.assertNotNull(output);
		Assertions.assertTrue(output instanceof Address);
	}
	@Test 
	public void testGetFlights() {
		var output= airport.getFlights();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof Flight);
		}
	}	
}
