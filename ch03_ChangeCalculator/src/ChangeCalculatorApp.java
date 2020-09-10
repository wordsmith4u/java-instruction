import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {
		final int CENTS_PER_QUARTER = 25;
		final int CENTS_PER_DIME = 10;
		final int CENTS_PER_NICKLE = 5;
		System.out.println("Welcome to the Change Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter number of cents (0-99): ");
			int cents = sc.nextInt();

			int numQuarters = cents / CENTS_PER_QUARTER;
			cents %= CENTS_PER_QUARTER;

			int numDimes = cents / CENTS_PER_DIME;
			cents %= CENTS_PER_DIME;

			int numNickle = cents / CENTS_PER_NICKLE;
			cents %= CENTS_PER_NICKLE;

			int numPennies = cents;

			System.out.println();
			System.out.println("Quarters:  " + numQuarters);
			System.out.println("Dimes:  " + numDimes);
			System.out.println("Nickles:  " + numNickle);
			System.out.println("Pennies:  " + numPennies);

			System.out.println();
			System.out.print("Continue? (y/n)");
			choice = sc.next();

		}
	}
}
