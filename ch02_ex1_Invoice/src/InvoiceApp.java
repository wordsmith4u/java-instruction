import java.util.Scanner;

public class InvoiceApp {

	// method for prompting welcome message
	private static void printWelcome() {
		System.out.println("Welcome to the Invoice Total Calculator");
		System.out.println();
	}

	// method for discount percent
	private static double findDiscountPercent(double subtotal) {
		double discountPercent;
		if (subtotal >= 200) {
			discountPercent = .2;
		} else if (subtotal >= 100) {
			discountPercent = .1;
		} else {
			discountPercent = 0.0;
		}
		return discountPercent;
	}

	public static void main(String[] args) {
		printWelcome();

		// create a Scanner object named sc
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// perform invoice calculations until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the invoice subtotal from the user
			System.out.print("Enter subtotal:   ");
			double subtotal = sc.nextDouble();

			// calculate the discount amount and total
			double discountPercent = findDiscountPercent(subtotal);

			double discountAmount = subtotal * discountPercent;
			double total = subtotal - discountAmount;

			// display the discount amount and total
			String message = "Discount percent: " + discountPercent + "\n" + "Discount amount:  " + discountAmount
					+ "\n" + "Invoice total:    " + total + "\n";
			System.out.println(message);

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}