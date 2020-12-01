
public class Ticket {
	FlightInstance flightInstance;
	Reservation reservation;

	public Ticket(Reservation reservation) {
		super();
		this.reservation = reservation;
	}
	
	public void setFlight(FlightInstance flight) {
		this.flightInstance = flight;
	}
	
}
