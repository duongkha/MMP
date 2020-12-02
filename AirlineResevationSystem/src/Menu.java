import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Airline;
import models.Flight;
import models.FlightInstance;
import models.Passenger;
import models.Reservation;
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
				 System.out.println("===================LIST OF AIRPORTS=========================");  
				 var airports = DataService.getInstance().getAirports();
				 for(var item:airports)
					 System.out.println(item.toString());
				 System.out.println("=============================================================");  
				break;
			case 2://view airline by departure airport code
				 System.out.print("Enter Airport Code:");
				 String code = readCommandString(); //CID
				// System.out.println(code);
				 if(!code.isEmpty()) {
					 System.out.println("===================LIST OF AIRLINES=========================");  
					List<Airline> airlines = DataService.getInstance().getAirlinesDepartFrom(code);
					for(Airline airline:airlines) {
						System.out.println(airline.toString());
					}	
					 System.out.println("=============================================================");  
				 }
				break;
			case 3://view flights between departure and destination with a date ->Dalai
<<<<<<< .merge_file_fWLNIQ
				//System.out.println( DataService.getInstance().getListOfFlights("CID", "ORD", LocalDate.of(2020, 12, 4)));
				//Lisa did for testing reservation, you can update,Dalai!
				System.out.print("Input Departure Airport Code:");
				String departureAiport = readCommandString(); //CID
				
				System.out.print("Input Arrival Airport Code:");
				String arrivalAiport = readCommandString(); //ORD

				System.out.print("Input Date:");
				String stringDate = readCommandString(); //2020-12-04
				LocalDate date = LocalDate.parse(stringDate);
				
				List<Flight> flights = DataService.getInstance().getListOfFlights(departureAiport, arrivalAiport, date);
				for(Flight flight: flights) {
					System.out.println(flight.toString() );
				}
				
=======
				System.out.println("===================LIST OF FLIGHTS=========================");  
				var flights =  DataService.getInstance().getListOfFlights("CID", "ORD", LocalDate.of(2020, 12, 4));
				for(var flight:flights) {
					System.out.println(flight);
				}
				
				System.out.println("=============================================================");  
>>>>>>> .merge_file_dYBuHy
				break;
			case 4://view own reservations
				if(userType == 1){//passenger
					var reservations = DataService.getInstance().getReservationsByPassengerId(userId);
					if(reservations != null) {
						System.out.println("===================LIST OF RESERVATIONS=========================");  
						for(var item:reservations)
							System.out.println(item);
						System.out.println("================================================================="); 
					}
				}
				else
				if(userType == 2){//agent
					var reservations = DataService.getInstance().getReservationsByAgentId(userId);
					if(reservations != null)
					{
						System.out.println("===================LIST OF RESERVATIONS=========================");  
						for(var item:reservations)
							System.out.println(item);
						System.out.println("================================================================="); 
					}
				}
				break;
			case 5://View details of a reservation ->Anuj: Input is reservatioId ->look at case 8 for reference
				System.out.println("Enter Reservation Number:");
				String reservationId = readCommandString();
				if(!reservationId.isEmpty()) {
					if(userType == 1) {
						var reservation = DataService.getInstance().getReservationIdAndPassenger(reservationId, userId);
						System.out.println(reservation);
					}
					else
					if(userType == 2){//agent
						var reservation = DataService.getInstance().getReservationIdAndAgent(reservationId,userId);
						System.out.println(reservation);
					}
				}
				break;
			case 6://Make a reservation ->Sa
				List<FlightInstance> flightInstances = new ArrayList<FlightInstance>();		
				
				System.out.print("Enter Passenger Id:");
				String PassengerId = readCommandString();
				
				Passenger passenger = DataService.getInstance().getPassengerById(PassengerId);
				
				while(true) {					
					System.out.print("Enter Flight Id:");
					String flightId = readCommandString();
					Flight flight = DataService.getInstance().getFlightById(flightId);
					/*if(flight == null) {
						System.out.println("Flight is not availablbe!");
						break;
					}*/
					System.out.print("Enter Date:");
					
					String strDate = readCommandString();
					LocalDate flightDate = LocalDate.parse(strDate);
					FlightInstance flightInst = flight.getFlightIntanceByDate(flightDate);
					if(flightInst !=null)
						flightInstances.add(flightInst);
					
					System.out.print("Enter another Flight (Y/N):");
					String cont = readCommandString();
					if(cont.compareToIgnoreCase("y") == 0 ) {
						continue;
					}
					break;						
				}
				
				Reservation reservation;
				if(userType == 1) {
					reservation = DataService.getInstance().makeReservation(flightInstances, null, passenger);
					System.out.println(reservation.toString());
				}
				else if (userType == 2) {
					reservation = DataService.getInstance().makeReservation(flightInstances, userId, passenger);
					System.out.println(reservation.toString());
				}
				
				break;
			case 7://Cancel a reservation
				System.out.println("Enter Reservation Number:");
				reservationId = readCommandString();
				if(!reservationId.isEmpty()) {
					if(userType == 1) {
						var result = DataService.getInstance().cancelReservationByPassenger(reservationId, userId);
						if(result) {
							System.out.println("Reservation " + reservationId +  " is cancelled.");
						}
						else
							System.out.println("ERROR: Reservation Not Found.");
					}
					else
					if(userType == 2){//agent
						var result = DataService.getInstance().confirmReservationByAgent(reservationId, userId);
						if(result) {
							System.out.println("Reservation " + reservationId +  " is cancelled.");
						}
						else
							System.out.println("ERROR: Reservation Not Found.");
					}
				}
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
