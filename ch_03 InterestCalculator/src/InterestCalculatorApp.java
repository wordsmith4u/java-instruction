import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Interest Calculator");
		System.out.println();

		// set scanner
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get input from user
			System.out.print("Enter Loan Amount:   ");
			BigDecimal loanAmount = sc.nextBigDecimal();
			System.out.print("Enter Interest Rate:   ");
			BigDecimal interestRate = sc.nextBigDecimal();
			System.out.println();

			// perform calculation
			BigDecimal interest = loanAmount.multiply(interestRate);
			interest = interest.setScale(2, RoundingMode.HALF_UP);

			// display the results
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);

			String message = "Loan Amount:" + currency.format(loanAmount) + "\n" + "Interest Rate:"
					+ percent.format(interestRate) + "\n" + "Interest:" + currency.format(interest) + "\n";
			System.out.println(message);

			// prompt to continue
			System.out.print("Continue? (y/n):");
			choice = sc.next();
			System.out.println();

		}
	}
}
