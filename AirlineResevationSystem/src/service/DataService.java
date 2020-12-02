package service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import models.Address;
import models.Agent;
import models.Airline;
import models.Airport;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;

public class DataService implements Repository{

	List<Airport> airports;
	List<Airline> airlines;
	List<Flight> flights;
	List<FlightInstance> flightInstances;
	List<Passenger> passengers;
	List<Agent> agents;
	List<Reservation> reservations;
	
	static Repository dataService = new DataService();
	public static Repository getInstance(){
		if(dataService == null)
			dataService = new DataService();
		return dataService;
	}
	
	DataService() {
		Initialize();
	}
	private void Initialize() {
		InitAirports();
		InitAirlines();
		InitFlights();
		InitFlightInstances();
		InitPassengers();
		InitAgents();
		InitReservations();
	}
	
	private void InitAirports() {
		airports  = new ArrayList<Airport>();
		var address1 = new Address("1","2121 Arthur Collins Pkwy SW","IA","Cedar Rapids","52404");
		var airport1 = new Airport("111","CID","Cedar Rapids", address1);
		var address2 = new Address("2","10000 W O'Hare Ave","IL","Chicago","60666");
		var airport2 = new Airport("112","ORD","O'Hare", address2);
		airports.add(airport1);
		airports.add(airport2);
	}
	
	private void InitAirlines() {
		airlines = new ArrayList<Airline>();
		var airline1 = new Airline("1", "AA", "American Airlines", "");
		var airline2 = new Airline("2", "UA","United Airlines","");
		var airline3 = new Airline("3", "DEL","Delta Airlines", "");
		airlines.add(airline1);
		airlines.add(airline2);
		airlines.add(airline3);
	}
	private void InitFlights() {
		flights = new ArrayList<Flight>();
		var airport1 = airports.get(0);
		var airport2 = airports.get(1);
		var airline1 = airlines.get(0);
		var airline2 = airlines.get(1);
		var flight1 = new Flight(LocalTime.of(7, 0),LocalTime.of(9, 15),"3333",
				200,airport1,airport2,airline1);
		var flight2 = new Flight(LocalTime.of(9, 30),LocalTime.of(11, 45),"7777",
				200,airport2,airport1,airline2);

		var flight3 = new Flight(LocalTime.of(15, 30),LocalTime.of(16, 45),"9999",
				300,airport1,airport2,airline1);
		
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
	}
	
	private void InitFlightInstances() {
		flightInstances = new ArrayList<FlightInstance>();
		String[] crews = {"Mary", "Lisa"};
		String[] pilots = {"Kha Nguyen","Anuj","Munkhdalai"};
		var flight1 = flights.get(0);
		var instance1 = new FlightInstance(flight1, "1111", LocalDate.of(2020, 12, 1));
		instance1.setCrews(List.of(crews));
		instance1.setPilots(List.of(pilots));
		flight1.addFlightInstance(instance1);
		var instance2 = new FlightInstance(flight1, "1112", LocalDate.of(2020, 12, 2));
		instance2.setCrews(List.of(crews));
		instance2.setPilots(List.of(pilots));
		flight1.addFlightInstance(instance2);
		var instance3 = new FlightInstance(flight1, "1113", LocalDate.of(2020, 12, 3));
		instance3.setCrews(List.of(crews));
		instance3.setPilots(List.of(pilots));
		flight1.addFlightInstance(instance3);
		var instance4 = new FlightInstance(flight1, "1114", LocalDate.of(2020, 12, 4));
		instance4.setCrews(List.of(crews));
		instance4.setPilots(List.of(pilots));
		flight1.addFlightInstance(instance4);
		
		var flight2 = flights.get(1);
		var instance5 = new FlightInstance(flight2, "1115", LocalDate.of(2020, 12, 1));
		instance5.setCrews(List.of(crews));
		instance5.setPilots(List.of(pilots));
		flight2.addFlightInstance(instance5);
		
		var instance6 = new FlightInstance(flight2, "1116", LocalDate.of(2020, 12, 2));
		instance6.setCrews(List.of(crews));
		instance6.setPilots(List.of(pilots));
		flight2.addFlightInstance(instance6);
		var instance7 = new FlightInstance(flight2, "1117", LocalDate.of(2020, 12, 3));
		instance7.setCrews(List.of(crews));
		instance7.setPilots(List.of(pilots));
		flight2.addFlightInstance(instance7);
		var instance8 = new FlightInstance(flight2, "1118", LocalDate.of(2020, 12, 4));
		instance8.setCrews(List.of(crews));
		instance8.setPilots(List.of(pilots));
		flight2.addFlightInstance(instance8);
		flightInstances.add(instance1);
		flightInstances.add(instance2);
		flightInstances.add(instance3);
		flightInstances.add(instance4);
		flightInstances.add(instance5);
		flightInstances.add(instance6);
		flightInstances.add(instance7);
		flightInstances.add(instance8);
	}
	private void InitPassengers() {
		passengers = new ArrayList<Passenger>();
		var p1 = new Passenger("1", "John", "Churchill",LocalDate.of(1990, 9, 10) ,"jonhchurchill@gmail.com");
		var p2 = new Passenger("2", "Mary", "Churchill",LocalDate.of(1991, 12, 19) ,"marychurchill@gmail.com");
		passengers.add(p1);
		passengers.add(p2);
	}
	private void InitAgents() {
		agents = new ArrayList<Agent>();
		var agent1 = new Agent("1", "Agent 1");
		var agent2 = new Agent("2", "Agent 2");
		agents.add(agent1);
		agents.add(agent2);
	}
	private void InitReservations() {
		reservations = new ArrayList<Reservation>();
		var instances = new ArrayList<FlightInstance>(); 
		instances.add(flightInstances.get(0)); //2020 12 01
		instances.add(flightInstances.get(5)); // 2020 12 02
		var reservation1 = new Reservation("000002",instances, agents.get(0).getAgentId(),
				passengers.get(0));
		passengers.get(0).addReservation(reservation1);
		var reservation2 = new Reservation("000001",instances, agents.get(0).getAgentId(),
				passengers.get(1));
		passengers.get(1).addReservation(reservation2);
		reservations.add(reservation1);
		reservations.add(reservation2);
	}
	public List<Airport> getAirports() {
		return airports;
	}
	
	public List<Airline> getAirlines(){
		return airlines;
	}
	
	public List<Flight> getFlights(){
		return flights;
	}
	public List<FlightInstance> getFlightInstances() {
		return flightInstances;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public Passenger getPassengerById(String id) {
		for(var item:this.passengers)
			if(item.getId().equalsIgnoreCase(id))
				return item;
		return null;
	}
	public Agent getAgentById(String id) {
		for(var item:this.agents)
			if(item.getAgentId().equalsIgnoreCase(id))
				return item;
		return null;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public List<Reservation> getReservations(Agent agent) {
		List<Reservation> list = new ArrayList<Reservation>();
		for(var item: this.reservations) {
			if(item.getAgentId().equalsIgnoreCase(agent.getAgentId()))
				list.add(item);
		}
		return list;
	}
	
	public List<Reservation> getReservations(Passenger passenger) {
		if(passenger != null)
			return passenger.getReservations();
		return null;
	}
	
	
	public boolean deleteReservation(String reservationId) {
		for(var item: this.reservations) {
			if(item.getReservationId().equalsIgnoreCase(reservationId)) {
				this.reservations.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public List<Reservation> getReservationsByPassengerId(String id){
		var passenger = DataService.getInstance().getPassengerById(id);
		if(passenger != null) {
			return passenger.getReservations();
		}
		return null;
	}
	
	public List<Reservation> getReservationsByAgentId(String id){
		var agent = DataService.getInstance().getAgentById(id);
		if(agent != null)
		{
			return agent.getReservations();
		}
		return null;
	}
	public boolean confirmReservationByPassenger(String reservationId,String passengerId) {
		var reservations = DataService.getInstance().getReservationsByPassengerId(passengerId);
		if(reservations != null) {
			//boolean found = false;
			for(var item:reservations){
				if(item.getReservationId().equalsIgnoreCase(reservationId)) {
					//found = true;
					if(item.getTickets().size() == 0) {
						boolean result = item.confirmReservation();
						if(result) {
							return true;
//							System.out.println("Reservation " + item.getReservationId() +  " purchased.");
//							break;
						}
					}
//					else {
//						System.out.println("Reservation purchased already.");
//						break;
//					}
				}
			}
		}
//		if(!found)
//			System.out.println("ERROR: Reservation Not Found.");
		return false;
	}
	public boolean confirmReservationByAgent(String reservationId,String agentId) {
		var reservations = DataService.getInstance().getReservationsByAgentId(agentId);
		
		if(reservations != null)
		{
			for(var item:reservations){
				if(item.getReservationId().equalsIgnoreCase(reservationId)) {
					if(item.getTickets().size() == 0) {
						return item.confirmReservation();
					}
				}
			}
		}
		return false;
	}
	/* By SaNguyen*/
	
	public List<Airline> getAirlinesDepartFrom(String airportCode){
		List<Airline> airlinesByAirportCode = new ArrayList<Airline>();

		for(Flight flight:flights) {
			if(flight.getDepartureAirport().getCode().equalsIgnoreCase(airportCode)) {
				if(!airlinesByAirportCode.contains(flight.getAirline()))
					airlinesByAirportCode.add(flight.getAirline());
			}
		}
		return airlinesByAirportCode;
	}
}
