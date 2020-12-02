import service.DataService;
public class Menu {
	private final String MENU_STRING_1 = "\nPLEASE SELECT:"+
						"\n1.View list of airports" + 
						"\n2.View list of airlines flying out of an airport (search by airport three letter code)" +
						"\n3.View list of flights between a departure and destination for a date";
	private final String VIEW_OWN_RESERVATION = "\n4.View list of own reservations";	
	private final String VIEW_AGENT_RESERVATION = "\n4.View list of passengers and reservations";	
	private final String MENU_STRING_2 = "\n5.View details of a reservation"+
											"\n6.Make a reservation"+
											"\n7.Cancel a reservation"+
											"\n8.Confirm and purchase a reservation.";
	
	private int userType;
	private String userId;
	public Menu(int userType) {
		// TODO Auto-generated constructor stub
		this.userType = userType;
	}
	
	public void readUserId() {
		String s = "";
		switch (userType) {
		case 1: 
			s = "YOU ARE LOGGED IN AS PASSENGER";
			break;
		case 2:
			s = "YOU ARE LOGGED IN AS AGENT";
			break;
//		case 3:
//			break;
		}
		s += "\nEnter your Id:";
		System.out.println(s); 
		userId = readCommandString();
	}
	
	public void loadMenu() {
		String menu = "";
		switch (userType) {
		//passenger
		case 1: {
			menu += MENU_STRING_1;
			menu += VIEW_OWN_RESERVATION;
			break;
		}
		//agent
		case 2: {
			menu += MENU_STRING_1;
			menu += VIEW_AGENT_RESERVATION;
			break;
		}
		//admin
		case 3: {
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
	    System.out.print("User input:");  
	    int commandIndex = Menu.readCommandIndex();
	    on_MenuSelected(commandIndex);
	}
	
	public void on_MenuSelected(int commandIndex) {
			switch(commandIndex) {
			case 1://view airports
				 System.out.println("List of airports:");  
				 var airports = DataService.getInstance().getAirports();
				 for(var item:airports)
					 System.out.println(item.toString());
				break;
			case 2://view airline by departure airport code
				 System.out.print("Enter Airport Code:");
				 String code = readCommandString();
				 if(!code.isEmpty()) {
					 
				 }
				break;
			case 3://view flights between departure and destination with a date
				break;
			case 4://view own reservations
				if(userType == 1){//passenger
					var reservations = DataService.getInstance().getReservationsByPassengerId(userId);
					if(reservations != null) {
						System.out.println("List of reservation:");  
						for(var item:reservations)
							System.out.println(item);
					}
				}
				else
				if(userType == 2){//agent
					var reservations = DataService.getInstance().getReservationsByAgentId(userId);
					if(reservations != null)
					{
						System.out.println("List of reservation:");  
						for(var item:reservations)
							System.out.println(item);
					}
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8://confirm reservation
				
				System.out.println("Enter Reservation Number:");
				String id = readCommandString();
				if(!id.isEmpty()) {
					if(userType == 1) {
						var result = DataService.getInstance().confirmReservationByPassenger(id, userId);
						if(result) {
							System.out.println("Reservation " + id +  " purchased.");
						}
						else
							System.out.println("ERROR: Reservation Not Found or confirmed already.");
					}
					else
					if(userType == 2){//agent
						var result = DataService.getInstance().confirmReservationByAgent(id, userId);
						if(result) {
							System.out.println("Reservation " + id +  " purchased.");
						}
						else
							System.out.println("ERROR: Reservation Not Found or confirmed already.");
					}
				}
				
				break;
			}
			System.out.println("Press ENTER to CONTINUE.");  
			readCommandString();
			loadMenu();
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
