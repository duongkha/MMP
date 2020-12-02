package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.Agent;
import models.Airport;
import models.Passenger;
import models.Reservation;
import service.Repository;

import org.junit.jupiter.api.BeforeAll;

public class AgentTest {
	private static Agent agent;
	
	@BeforeAll
	public static void setUp() {
		agent = new Agent("99", "Johnson");
	}
	
	@Test
	public void testGetId() {
		var output = agent.getAgentId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("99", output);
	}
	@Test
	public void testGetAgentName() {
		var output = agent.getName();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Johnson", output);
	}
	@Test
	public void testGetPassengers() {
		var output = agent.getPassengers();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof Passenger);
		}
	}
	@Test
	public void testGetReservations() {
		var output = agent.getReservations();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof Reservation);
		}
	}
	@Test
	public void testGetAirports() {
		var output = agent.getAirports();
		Assertions.assertNotNull(output);
		for(var v: output) {
			Assertions.assertTrue(v instanceof Airport);
		}
	}
}
