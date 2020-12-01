import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Repository {

	static List<Airport> airports;
	static List<Airline> airlines;
	static List<Flight> flights;
	public Repository() {
		Initialize();
	}
	private void Initialize() {
		InitAirports();
		InitAirlines();
		InitFlights();
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
		var flight1 = new Flight(LocalTime.of(7, 0),LocalTime.of(9, 15),"3333",
				200,airport1,airport2);
		var flight2 = new Flight(LocalTime.of(9, 30),LocalTime.of(11, 45),"7777",
				200,airport2,airport1);
		flights.add(flight1);
		flights.add(flight2);
		
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
	
}
