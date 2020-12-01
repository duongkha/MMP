import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightInstance {
	List<Reservation> reservations;
	Flight flight;
	String id;
	LocalDate date;
	List<String> crews;
	List<String> pilots;
	List<Ticket> tickets;
	
	public FlightInstance(Flight flight,String id,LocalDate date) {
		if(flight != null) {
			this.flight = flight;
			this.flight.addFlightInstance(this);
		}
		this.id = id;
		this.date = date;
		crews = new ArrayList<String>();
		pilots = new ArrayList<String>();
		tickets = new ArrayList<Ticket>();
		reservations = new ArrayList<Reservation>();
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<String> getCrews() {
		return crews;
	}
	public void setCrews(List<String> crews) {
		this.crews = crews;
	}
	public List<String> getPilots() {
		return pilots;
	}
	public void setPilots(List<String> pilots) {
		this.pilots = pilots;
	}
	public String getId() {
		return id;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
	@Override
	   public String toString() {
	        return ("id: " + this.id +
	        			",date: " + this.date +
	                    " ,flight: "+ this.flight +
	                    ", crews: " + this.crews.toString() + 
	                    ", pilots: " + this.pilots.toString()
	                    );
	   }
}
