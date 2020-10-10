import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Age Calculator\n");

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Get input from the the user
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your date of birth (YYYY-MM-DD): ");
		String dateOfBirthString = sc.nextLine();
		System.out.println();

		// Get and validate user's date of birth
		LocalDate birthDate = LocalDate.parse(dateOfBirthString);

		// If user's date of birth is valid
		if (birthDate.isBefore(currentDate)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

			// Format and print user's date of birth
			System.out.println("Your date of birth is " + dtf.format(birthDate));

			// Format and print the current date
			LocalDate currentDate1 = LocalDate.now();
			System.out.println("The current date is " + dtf.format(currentDate));

			// Calculate and print the user's age
			long yearsOld = birthDate.until(currentDate, ChronoUnit.YEARS);

			System.out.println("Your age is " + yearsOld + " years old");

		} else {
			System.out.println("Birthdate must be in the past");
		}
	}
}