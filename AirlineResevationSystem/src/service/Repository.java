package service;

import java.util.List;

import models.Agent;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;

public interface Repository {
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
	boolean confirmReservationByPassenger(String reservationId,String passengerId);
	boolean confirmReservationByAgent(String reservationId,String agentId);
	boolean cancelReservationByPassenger(String reservationId,String passengerId);
	boolean cancelReservationByAgent(String reservationId,String agentId);
	List<Airline> getAirlinesDepartFrom(String airportCode);
	List<Reservation> getReservationsByPassengerId(String id);
	List<Reservation> getReservationsByAgentId(String id);	
	void makeReservation(String reservationId, List<FlightInstance> flightInstances, String agentId, Passenger passenger);
	Reservation getReservationIdAndAgent(String reservationId, String agentId);
	Reservation getReservationIdAndPassenger(String reservationId, String passengerId);
	
}
