package models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightInstance  implements Comparable<FlightInstance>{
	Flight flight;
	String id;
	LocalDate date;
	List<String> crews;
	List<String> pilots;
	List<Ticket> tickets;
	
	public FlightInstance(Flight flight,String id,LocalDate date) {
		this.id = id;
		this.date = date;
		crews = new ArrayList<String>();
		pilots = new ArrayList<String>();
		tickets = new ArrayList<Ticket>();
		if(flight != null) {
			this.flight = flight;
		}
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
	@Override
	public int compareTo(FlightInstance instance) {
		if(instance != null) {
			if(instance.getId().equalsIgnoreCase(this.getId())) {
				return 1;
			}
		}
		return 0;
	}
	@Override
	   public String toString() {
	        return ("ID: " + this.id +
	        			"\tDATE: " + this.date +
	                    "\nFLIGHT:\n "+ this.flight +
	                    "\nCREWS: " + this.crews.toString() + 
	                    "\nPILOTS: " + this.pilots.toString()
	                    );
	   }
}
