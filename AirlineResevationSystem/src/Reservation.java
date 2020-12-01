import java.util.ArrayList;
import java.util.List;

public class Reservation {
	List<Ticket> tickets;
	List<FlightInstance> flightInstance;
	String agentId;
	Passenger passenger;

	public Reservation(List<FlightInstance> flightInstance, String agentId, Passenger passenger) {
		super();
		this.flightInstance = flightInstance;
		this.agentId = agentId;
		this.passenger = passenger;
		this.tickets = new ArrayList<Ticket>();
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

	@Override
	   public String toString() {
	        return ("agent id: " + this.agentId +
	        			",Flight Instances: " + this.flightInstance.toString() +
	                    " ,Passenger: "+ this.passenger.toString() +
	                    ", Tickets: " + this.tickets.toString()
	                    );
	   }
	
	public boolean confirmReservation() {
		//create new tickets
		if(this.flightInstance.size() > 0) {
			for(var instance:flightInstance) {
				var ticket = new Ticket(instance,this);
				instance.addTicket(ticket);
				this.tickets.add(ticket);
			}
			return true;
		}
		return false;
	}
	public boolean makeReservation() {
		return false;
	}
	
}
