package tests;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import models.Passenger;


public class PassengerTest {
	private static Passenger passenger;
	
	@BeforeAll
	public static void setUp() {
		passenger = new Passenger("065", "John", "Doe", LocalDate.of(1990, 10, 10), "john@doe.com");
	}
	
	@Test
	public void testGetId() {
		var output = passenger.getId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("065", output);
	}
	
	@Test
	public void testGetFirstName() {
		var output = passenger.getFirstName();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("John", output);
	}
	
	@Test
	public void testGetLastName() {
		var output = passenger.getLastName();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Doe", output);
	}
	
	@Test
	public void testGetDOB() {
		var output = passenger.getDOB();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.toString().isEmpty());
		Assertions.assertEquals(LocalDate.of(1990, 10, 10), output);
	}
	
	@Test
	public void testGetEmailAddress() {
		var output = passenger.getEmailAddress();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("john@doe.com", output);
	}
	
	@Test
	public void testGetReservations() {
		var output = passenger.getReservations();
		Assertions.assertNotNull(output);
	}
}
