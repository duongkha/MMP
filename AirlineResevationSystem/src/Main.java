import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static String userName;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repository repo = new Repository();
		System.out.println("Welcome to Airline Reservation System");
//		Scanner myObj = new Scanner(System.in); 
//	    System.out.println("Enter username");
//
//	    userName = myObj.nextLine();  
//	    System.out.println("Username is: " + userName);  
//	    String password = myObj.nextLine(); 
//	    checkUserType();
	    
		var airlines = repo.getAirlines();
		System.out.println("Airline list:" +  airlines.toString());
		var airports = repo.getAirports();
		System.out.println("Airport list:" +  airports.toString());
		var flights = repo.getFlights();
		System.out.println("Flight list:" +  flights.toString());
		var instances = repo.getFlightInstances();
		System.out.println("Flight Instance list:" +  instances.toString());
	}
	private static void checkUserType() {
		
	}

}
