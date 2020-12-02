package service;

import java.util.List;

import models.Agent;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;

public interface DataService {
	List<Airport> getAirports();
	List<Airline> getAirlines();
	List<Flight> getFlights();
	List<FlightInstance> getFlightInstances();
	List<Agent> getAgents();
	List<Passenger> getPassengers();
	Passenger getPassengerById(String id);
	Agent getAgentById(String id);
	List<Reservation> getReservations();
	List<Reservation> getReservations(Agent agent);
	List<Reservation> getReservations(Passenger passenger);
	boolean deleteReservation(String reservationId);
	List<Airline> getAirlinesDepartFrom(String airportCode);
	
}
