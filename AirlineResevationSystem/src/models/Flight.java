package models;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
	LocalTime departureTime;
	LocalTime arrivalTime;
	String flightId;
	int capacity;
	
	Airport departureAirport;
	Airport arrivalAirport;
	List<FlightInstance> flightInstances;
	Airline airline;
	
	public Flight(LocalTime departureTime, LocalTime arrivalTime, String flightId, int capacity,
			Airport departureAirport, Airport arrivalAirport, Airline airline) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightId = flightId;
		this.capacity = capacity;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		flightInstances = new ArrayList<FlightInstance>();
		this.airline = airline;
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
	        return ("ID: " + this.flightId +
	        			"\tDEPARTURE TIME: " + this.departureTime +
	                    " \tDEPARTURE AIRPORT: "+ this.departureAirport +
	                    "\tARRIVAL TIME: " + this.arrivalTime + 
	                    "\tARRIVAL AIRPORT: " + this.arrivalAirport
	                    );
	   }
	public void addFlightInstance(FlightInstance instance) {
		flightInstances.add(instance);
	}
	
	
	public Airline getAirline() {
		return airline;
	}



}
