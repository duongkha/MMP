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
}
