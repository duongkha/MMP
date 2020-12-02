package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.Address;
import org.junit.jupiter.api.BeforeAll;

public class AddressTest {
	private static Address address;
	
	@BeforeAll
	public static void setUp() {
		address = new Address("064", "1000 Nth Street", "Fairfield", "Iowa", "52557");
	}
	@Test
	public void testGetAddressId() {
		var output = address.getAddressId();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("064", output);
	}
	@Test
	public void testGetStreet() {
		var output = address.getStreet();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("1000 Nth Street", output);
	}
	@Test
	public void testGetState() {
		var output = address.getState();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Iowa", output);
	}
	@Test
	public void testGetCity() {
		var output = address.getCity();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("Fairfield", output);
	}
	@Test
	public void testZip() {
		var output = address.getZip();
		Assertions.assertNotNull(output);
		Assertions.assertFalse(output.isEmpty());
		Assertions.assertEquals("52557", output);
	}
}
