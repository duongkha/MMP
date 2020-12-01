import java.util.Arrays;
import java.util.Scanner;

import service.Repository;

public class Main {
	private static String userName;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repository repo = Repository.getInstance();
		System.out.println("Welcome to Airline Reservation System");
//		Scanner myObj = new Scanner(System.in); 
//	    System.out.println("Enter username");
//
//	    userName = myObj.nextLine();  
//	    System.out.println("Username is: " + userName);  
//	    String password = myObj.nextLine(); 
//	    checkUserType();
	    
//		var airlines = repo.getAirlines();
//		System.out.println("Airline list:" +  airlines.toString());
//		var airports = repo.getAirports();
//		System.out.println("Airport list:" +  airports.toString());
//		var flights = repo.getFlights();
//		System.out.println("Flight list:" +  flights.toString());
//		var instances = repo.getFlightInstances();
//		System.out.println("Flight Instance list:" +  instances.toString());
//		var passengers = repo.getPassengers();
//		System.out.println("Passenger list:" +  passengers.toString());
//		var agents = repo.getAgents();
//		System.out.println("Agent list:" +  agents.toString());
		var reservations = repo.getReservations();
		//System.out.println("Reservation list:" +  reservations.toString());
		var reser1 = reservations.get(0);
		var result =  reser1.confirmReservation();
		if(result) {
			System.out.println(reser1.toString());
		}
		result =  reser1.cancel();
		if(result) {
			System.out.println("Reservation is cancelled.");
		}
	}
	private static void checkUserType() {
		
	}

}
