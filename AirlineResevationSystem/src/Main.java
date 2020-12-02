import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Airline Reservation System");
		System.out.println("Select user role:");
		  System.out.println("1.Passenger");
		  System.out.println("2.Agent");
		  System.out.println("3.Admin");
		  System.out.print("User input:");  
		
		int commandIndex = Menu.readCommandIndex();
	
	    if(commandIndex > -1) {
		    var menu = new Menu(commandIndex);
		    menu.readUserId();
		    menu.loadMenu();
		
	    }
	    else {
	    	 System.out.println("User not found");  
	    }
	    scanner.close();
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
//		var reservations = repo.getReservations();
		//System.out.println("Reservation list:" +  reservations.toString());
//		var reser1 = reservations.get(0);
//		var result =  reser1.confirmReservation();
//		if(result) {
//			System.out.println(reser1.toString());
//		}
//		result =  reser1.cancel();
//		if(result) {
//			System.out.println("Reservation is cancelled.");
//		}
	}
	
}
