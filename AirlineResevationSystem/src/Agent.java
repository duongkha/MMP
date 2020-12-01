import java.util.List;

public class Agent {
	String agentId;
	String name;
	
	public Agent(String agentId, String name) {
		super();
		this.agentId = agentId;
		this.name = name;
	}

	public String getAgentId() {
		return agentId;
	}
	public String getName() {
		return name;
	}
	
	public List<Passenger> getPassengers(){
		return null;
	}
	public List<Reservation> getReservations(){
		return null;
	}
	@Override
	   public String toString() {
	        return ("id: " + this.agentId +
	        			",Name: " + this.name
	                    );
	   }
}
