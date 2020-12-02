package models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import service.DataService;
import service.Repository;

public class Passenger {
	private String Id;
	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String emailAddress;
	private List<Reservation> reservations;
	
	public Passenger(String id, String firstName, String lastName, LocalDate dOB, String emailAddress) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.emailAddress = emailAddress;
		reservations = new ArrayList<Reservation>();
	}
	public String getId() {
		return Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
	
	public List<Airport> getAirports(){
		return DataService.getInstance().getAirports();
	}
	
	@Override
   public String toString() {
        return ("id: " + this.Id +
        			",Full Name: " + this.firstName + " " + this.lastName +
                    ", DOB: " + this.DOB + 
                    ", email: " + this.emailAddress
                    );
    }
}
