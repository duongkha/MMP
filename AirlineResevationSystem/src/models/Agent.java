package models;
import java.util.ArrayList;
import java.util.List;

import service.Repository;

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
		var reservations = Repository.getInstance().getReservations(this);
		if(reservations != null) {
			List<Passenger> list = new ArrayList<Passenger>();
			for(var item: reservations)
				list.add(item.passenger);
			return list;
		}
		return null;
	}
	public List<Reservation> getReservations(){
		return Repository.getInstance().getReservations(this);
	}
	@Override
	   public String toString() {
	        return ("id: " + this.agentId +
	        			",Name: " + this.name
	                    );
	   }
}
