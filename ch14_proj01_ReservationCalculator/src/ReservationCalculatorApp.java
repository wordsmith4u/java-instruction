import java.time.LocalDate;
import java.util.Scanner;

public class ReservationCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Reservation Calculator\n");

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			LocalDate arrivalDate = Console.getLocalDate("arrival");
			System.out.println();
			LocalDate departureDate = Console.getLocalDate("departure");
			System.out.println();

			Reservation res = new Reservation(arrivalDate, departureDate);

			System.out.println("Arrival Date: " + res.getArrivalDateFormatted());
			System.out.println("Departure Date: " + res.getDepartureDateFormatted());
			System.out.println("Price: " + res.getPricePerNightFormatted());
			System.out.println(
					"Total Price: " + res.getTotalPriceFormatted() + " for " + res.getNumberOfNights() + " nights.");
			System.out.println();

			choice = Console.getString("Continue? (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				choice = sc.nextLine();
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Bye!");

			}
		}
	}
}
