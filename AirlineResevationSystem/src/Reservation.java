import java.util.ArrayList;
import java.util.List;

public class Reservation {
	List<Ticket> tickets;
	List<FlightInstance> flightInstance;
	String agentId;

	public Reservation() {
		flightInstance = new ArrayList<FlightInstance>();
		tickets = new ArrayList<Ticket>();
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public List<FlightInstance> getFlightInstance() {
		return flightInstance;
	}

	public String getAgentId() {
		return agentId;
	}

	public boolean confirmReservation() {
		//create new tickets
		return false;
	}
	public boolean makeReservation() {
		return false;
	}
}
