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
	}
}
