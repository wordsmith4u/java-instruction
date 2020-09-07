import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Interest Calculator");
		System.out.println();

		double loanAmount = 0;
		double interestAmount = 0;
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter Loan Amount:   ");
			loanAmount = sc.nextDouble();
			System.out.print("Enter Interest Rate:   ");
			interestAmount = sc.nextDouble();
			System.out.println();

			double interest = loanAmount * interestAmount;

			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);

			String message = "Loan Amount:" + currency.format(loanAmount) + "\n" + "Interest Rate:"
					+ percent.format(interestAmount) + "\n" + "Interest:" + currency.format(interest) + "\n";
			System.out.println(message);

			System.out.print("Continue? (y/n):");
			choice = sc.next();
			System.out.println();

		}
	}
}
