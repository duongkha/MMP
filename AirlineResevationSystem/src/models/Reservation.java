package models;
import java.util.ArrayList;
import java.util.List;

import service.Repository;

public class Reservation implements Comparable<Reservation>{
	List<Ticket> tickets;
	List<FlightInstance> flightInstance;
	String reservationId;
	String agentId;
	Passenger passenger;

	public Reservation(String reservationId, List<FlightInstance> flightInstance, String agentId, Passenger passenger) {
		super();
		this.reservationId = reservationId;
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
	
	public String getReservationId() {
		return reservationId;
	}

	public String getAgentId() {
		return agentId;
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
		for(var instance:this.flightInstance) {
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
	public boolean cancel() {
		return Repository.getInstance().deleteReservation(this.reservationId);
	}
	
	public boolean makeReservation() {
		return false;
	}
	
}
