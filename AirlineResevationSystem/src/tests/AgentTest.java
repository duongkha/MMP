package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.Agent;
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
}
