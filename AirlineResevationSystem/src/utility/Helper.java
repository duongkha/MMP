package utility;
import java.util.Random;

public class Helper {
	public static String generateTicketNumber() {
		return generateRandom(20);
	}

	public static String generateReservationId() {
		return generateRandom(20);
	}
	
	public static String generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return new String(digits);
	}
}
