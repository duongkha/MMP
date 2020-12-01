import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repository repo = new Repository();
		System.out.println("Airline Reservation System");
		var airlines = repo.getAirlines();
		System.out.println("Airline list:" +  airlines.toString());
		var airports = repo.getAirports();
		System.out.println("Airport list:" +  airports.toString());
	}

}
