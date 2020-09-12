import java.util.Scanner;

public class TimeTravelCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Time Travel Calculator");
		System.out.println();

		double miles = 0;
		double mph = 0;
		final int MINS_PER_HOUR = 60;
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter Miles:                  ");
			miles = sc.nextDouble();
			System.out.print("Enter Miles Per Hour:         ");
			mph = sc.nextDouble();
			System.out.println();
			System.out.println("Estimated Travel Time       ");

			double hours = miles / mph;
			hours = (int) Math.round(hours * 100) / 100;

			double miles_left = miles % mph;
			double minutes = miles_left % MINS_PER_HOUR;
			minutes = (int) Math.round(minutes * 100) / 100;

			System.out.println("Hours:" + hours);
			System.out.println("Minutes:" + minutes);

			System.out.println();
			System.out.print("Continue? (y/n):");
			choice = sc.next();
			System.out.println();

		}
	}
}
