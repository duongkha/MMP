import java.util.ArrayList;
import java.util.List;

public class Airline {
	String airlineId;
	String code;
	String name;
	String history;
	List<Flight> flights;
	
	public Airline(String airlineId, String code, String name, String history) {
		super();
		this.airlineId = airlineId;
		this.code = code;
		this.name = name;
		this.history = history;
		this.flights = new ArrayList<Flight>();
	}
	public String getAirlineId() {
		return airlineId;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getHistory() {
		return history;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	
	 @Override
	   public String toString() {
	        return ("id: " + this.airlineId+
	        			",code: " + this.code+
	                    " ,name: "+ this.name);
	   }
	 
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}
}
