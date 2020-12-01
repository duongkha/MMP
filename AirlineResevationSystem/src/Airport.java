import java.util.ArrayList;
import java.util.List;

public class Airport {
	String airportId;
	String code;
	String name;
	List<Flight> flights;
	Address address;
	
	public Airport(String airportId, String code, String name,Address address) {
		super();
		this.airportId = airportId;
		this.code = code;
		this.name = name;
		this.address = address;
		flights = new ArrayList<Flight>();
	}
	public String getAirportId() {
		return airportId;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public Address getAddress() {
		return address;
	}
	public List<Flight> getFlights(){
		return flights;
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}
}
