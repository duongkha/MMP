import java.util.Scanner;

import service.Repository;

public class Menu {
	private final String MENU_STRING_1 = "\nPLEASE SELECT:"+
						"\n1.View list of airports" + 
						"\n2.View list of airlines flying out of an airport (search by airport three letter code)" +
						"\n3.View list of flights between a departure and destination for a date";
	private final String VIEW_OWN_RESERVATION = "4.View list of own reservations";	
	private final String VIEW_AGENT_RESERVATION = "4.View list of passengers and reservations";	
	private final String MENU_STRING_2 = "\n5.View details of a reservation"+
											"\n6.Make a reservation"+
											"\n7.Cancel a reservation"+
											"\n8.Confirm and purchase a reservation.";
	
	private int userType;
	public Menu(int userType) {
		// TODO Auto-generated constructor stub
		this.userType = userType;
	}
	
	public void loadMenu() {
		String menu = "";
		switch (userType) {
		//passenger
		case 0: {
			menu = "YOU ARE LOGGED IN AS PASSENGER";
			menu += MENU_STRING_1;
			menu += VIEW_OWN_RESERVATION;
			break;
		}
		//agent
		case 1: {
			menu = "YOU ARE LOGGED IN AS AGENT";
			menu += MENU_STRING_1;
			menu += VIEW_AGENT_RESERVATION;
			break;
		}
		//admin
		case 2: {
//			menu = "You are logged in as Admin";
//			menu += MENU_STRING_1;
//			menu += VIEW_AGENT_RESERVATION;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + userType);
		}
		menu  += MENU_STRING_2;
		 System.out.println(menu);  
	}
	
	public void on_MenuSelected(int commandIndex) {
		switch(commandIndex) {
		case 1://view airports
			 System.out.println("List of airports:");  
			 var airports = Repository.getInstance().getAirports();
			 for(var item:airports)
				 System.out.println(item.toString());
			break;
		case 2://view airline by departure airport code
			 System.out.print("Enter Airport Code:");
			 String code = readCommandString();
			 if(!code.isEmpty()) {
				 
			 }
			break;//view flights between departure and destination with a date
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
		 System.out.println("Press ESC to back to MENU.");  
	}
	public static int readCommandIndex() {
		String input = Main.scanner.nextLine();  
		int commandIndex = -1;
		try {
			commandIndex = Integer.parseInt(input);
		}catch(Exception ex) {
			 System.out.println("ERROR:command unknown.");  
			 return -1;
		}
		return commandIndex;
	}
	public static String readCommandString() {
		return Main.scanner.nextLine();  
	}
}
