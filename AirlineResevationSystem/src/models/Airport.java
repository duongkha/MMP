package models;

public class Airport {
	String airportId;
	String code;
	String name;
	Address address;
	
	public Airport(String airportId, String code, String name,Address address) {
		super();
		this.airportId = airportId;
		this.code = code;
		this.name = name;
		this.address = address;
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
	 @Override
	   public String toString() {
	        return ("ID: " + this.airportId + "\tCODE: " + this.code + "\tNAME: "+ this.name);
	   }
}
