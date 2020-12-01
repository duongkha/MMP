package models;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight{
	LocalTime departureTime;
	LocalTime arrivalTime;
	String flightId;
	int capacity;
	
	Airport departureAirport;
	Airport arrivalAirport;
	List<FlightInstance> flightInstances;
	
	public Flight(LocalTime departureTime, LocalTime arrivalTime, String flightId, int capacity,
			Airport departureAirport, Airport arrivalAirport) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightId = flightId;
		this.capacity = capacity;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		flightInstances = new ArrayList<FlightInstance>();
	}
	
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public String getFlightId() {
		return flightId;
	}
	public int getCapacity() {
		return capacity;
	}
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public List<FlightInstance> getFlightInstances() {
		return flightInstances;
	}
	@Override
	   public String toString() {
	        return ("id: " + this.flightId +
	        			",departure time: " + this.departureTime +
	                    " ,departure airport: "+ this.departureAirport +
	                    ", arrival time: " + this.arrivalTime + 
	                    ", arrival airport: " + this.arrivalAirport
	                    );
	   }
	public void addFlightInstance(FlightInstance instance) {
		flightInstances.add(instance);
	}
}