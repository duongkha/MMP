package models;

import utility.Helper;

public class Ticket {
	FlightInstance flightInstance;
	Reservation reservation;
	String ticketId;
	String ticketNumber;

	
	public Ticket(FlightInstance flightInstance, Reservation reservation) {
		this.flightInstance = flightInstance;
		this.reservation = reservation;
		ticketId = ticketNumber = Helper.generateTicketNumber();
	}

	public Ticket(Reservation reservation) {
		this.reservation = reservation;
		ticketId = ticketNumber = Helper.generateTicketNumber();
	}
	
	public void setFlight(FlightInstance flight) {
		this.flightInstance = flight;
	}

	public String getTicketId() {
		return ticketId;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public FlightInstance getFlightInstance() {
		return flightInstance;
	}
	@Override
	   public String toString() {
	        return ("ID: " + this.ticketId + "\tTICKET NUMBER: " + this.ticketNumber);
	   }
}
