package models;
import java.util.ArrayList;
import java.util.List;

import utility.Helper;


public class Reservation implements Comparable<Reservation>{
	List<Ticket> tickets;
	List<FlightInstance> flightInstances;
	String reservationId;
	String agentId;
	Passenger passenger;

	public Reservation(String reservationId, List<FlightInstance> flightInstances, String agentId, Passenger passenger) {
		super();
		this.reservationId = reservationId;
		this.flightInstances = flightInstances;
		this.agentId = agentId;
		this.passenger = passenger;
		this.tickets = new ArrayList<Ticket>();
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public List<FlightInstance> getFlightInstances() {
		return flightInstances;
	}
	
	public String getReservationId() {
		return reservationId;
	}

	public String getAgentId() {
		return agentId;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	@Override
	public int compareTo(Reservation reservation) {
		if(reservation != null) {
			if(reservation.getReservationId().equalsIgnoreCase(reservationId)) {
				return 1;
			}
		}
		return 0;
	}
	@Override
	   public String toString() {
		//TODO: well-formed printing
		String s = "=============================SERVERVATION INFORMATION================================="+
					"\nSERVERVATION ID: " + this.reservationId +
					"\nAGENT ID:" + this.agentId +
					"\nPASSENGER INFORMATION:"+
					"\nNAME: " + this.passenger.getFirstName() + "," + this.passenger.getLastName()+
					"\nDOB: " + this.passenger.getDOB().toString() +
					"\nEMAIL: " + this.passenger.getEmailAddress();
		s += "\n===========================FLIGHT INFORMATION=================================";
		for(var instance:this.flightInstances) {
			String s1 ="\nFLIGHT ID: " + instance.getFlight().getFlightId() + 
					"\t\tFLIGHT DATE:" + instance.getDate().toString() + 
					"\nFROM: " + instance.getFlight().getDepartureAirport().getCode() + 
					"\tTO: " + instance.getFlight().getArrivalAirport().getCode() +
					"\t\tDEPARTURE TIME: " + instance.getFlight().getDepartureTime().toString() + 
					"\t\tARRIVAL TIME: " + instance.getFlight().getArrivalTime().toString();
			s += s1;
			if(this.tickets.size() > 0){
				boolean found = false;
				for(var ticket:this.tickets) {
					if(ticket.getFlightInstance().compareTo(instance) > 0){
						s += "\nTICKET NUMBER: " + ticket.getTicketNumber();
						found = true;
						break;
					}
				}
				if(!found)
					s += "\nNO TICKET ISSUED";
			}
			s += "\n";
		}
		
		s += "\n==================================================================================";
		return s;
//	        return ("agent id: " + this.agentId +
//	        			",Flight Instances: " + this.flightInstance.toString() +
//	                    " ,Passenger: "+ this.passenger.toString() +
//	                    ", Tickets: " + this.tickets.toString()
//	                    );
	   }
	
	public boolean confirmReservation() {
		//create new tickets
		if(this.flightInstances.size() > 0) {
			for(var instance:flightInstances) {
				var ticket = new Ticket(instance,this);
				instance.addTicket(ticket);
				this.tickets.add(ticket);
			}
			return true;
		}
		return false;
	}
	
	public static Reservation makeReservation(List<FlightInstance> flightInstances, String agentId, Passenger passenger) {
		String reservationId = Helper.generateTicketNumber();
		if(flightInstances == null || flightInstances.isEmpty() || passenger == null) {
			return null;	
		}
		return new Reservation(reservationId, flightInstances, agentId, passenger);
			
	}
	
}
