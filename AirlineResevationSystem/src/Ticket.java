
public class Ticket {
	FlightInstance flightInstance;
	Reservation reservation;
	String ticketId;
	String ticketNumber;

	public Ticket(Reservation reservation) {
		super();
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
	
}
