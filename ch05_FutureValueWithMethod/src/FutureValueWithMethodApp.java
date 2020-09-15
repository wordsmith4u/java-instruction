import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueWithMethodApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (!choice.equalsIgnoreCase("n")) {

			double monthlyInvestment;
			double interestRate;
			int years;

			// get the input from the user though using methods below
			monthlyInvestment = getDoubleWithinRange(sc, "Enter Monthly Investment:", 0, 1000);

			interestRate = getDoubleWithinRange(sc, "Enter Yearly Interest Rate:", 0, 30);

			years = getIntWithinRange(sc, "Enter Number of Years: ", 0, 100);

			// convert yearly values to monthly values
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years * 12;

			// call the future value method
			double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

			// format and display the result
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			System.out.println("Future value:               " + currency.format(futureValue));
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}

	// method one
	public static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
		double futureValue = 0.0;
		for (int i = 1; i <= months; i++) {
			futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
		}
		return futureValue;
	}

	// method two
	public static double getDouble(Scanner sc, String prompt) {
		double retVal = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				retVal = sc.nextDouble();
				isValid = true;
				sc.nextLine();
			} else {
				System.out.println("Invalid Amount");
				sc.nextLine();
			}
		}
		return retVal;
	}

	// method three
	public static int getInt(Scanner sc, String prompt) {
		int retVal = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				retVal = sc.nextInt();
				isValid = true;
				sc.nextLine();
			} else {
				System.out.println("Invalid Amount");
				sc.nextLine();
			}
		}
		return retVal;
	}

	// method four
	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(sc, prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (d >= max) {
				System.out.println("Error! Number must be greater than " + max + ".");
			} else {
				isValid = true;
			}

		}
		return d;
	}

	// method five
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(sc, prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be greater than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}
}