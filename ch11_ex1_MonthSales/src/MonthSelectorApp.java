import java.text.NumberFormat;

public class MonthSelectorApp {

	public static void main(String[] args) {
		System.out.println("Monthly Sales\n");

		// declare monthNames and monthSales arrays
		String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		double[] monthSales = { 100.00, 25.95, 30.05, 24.99, 15.25, 35.30, 5.99, 45.00, 26.99, 10.25, 60.99, 26.99 };

		// get currency formatting
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// get one or more months
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			int monthNumber = Console.getInt("Enter month number: ");

			// validate input
			if (monthNumber < 1 || monthNumber > monthNames.length) {
				Console.displayLine("Invalid month number. Try again.");
				continue;
			}

			// get the index number for the month
			// and display the month name and sales
			int monthIndex = monthNumber - 1;
			String monthName = monthNames[monthIndex];
			double salesForMonth = monthSales[monthIndex];

			System.out.println("Sales for " + monthName + ": " + currency.format(salesForMonth));

			// check if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			Console.displayLine();
		}

		// display the total sales for the year
		// Regular ForLoop
		double totalSales = 0.0;

		for (int i = 0; i < monthSales.length; i++) {
			totalSales = totalSales + monthSales[i];
		}

		// Enhanced ForLoop example
		// for (double sales : monthSales) {
		// totalSales = totalSales + sales;
		// }

		System.out.println();
		System.out.println("Total sales: " + currency.format(totalSales));

		Console.displayLine();
	}
}