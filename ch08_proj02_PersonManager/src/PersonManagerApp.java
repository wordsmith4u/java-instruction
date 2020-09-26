import java.util.Scanner;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		System.out.println();

		Person p = new Person();

		Scanner sc = new Scanner(System.in); // Set scanner
		String choice = "y"; // as long as we keep getting input, we keep scanning
		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Create customer or employer? (c/e): "); // prompt for c or e
			String creation = sc.next(); // user answer
			sc.nextLine();
			String fn = Console.getString("Enter first name:  "); // prompt for first name
			String ln = Console.getString("Enter last name: "); // prompt for last name
			System.out.println();

			// verify if the customer is "c" or "e"
			if (creation.equalsIgnoreCase("c")) {
				Customer c = new Customer(); // declare new customer
				String cNumber = Console.getString("Customer Number:     "); // prompt for customer number
				c.setCustomerNumber(cNumber);
				c.setFirstName(fn); // call first name
				c.setLastName(ln); // call last name
				System.out.println("You entered a new customer" + "\n" + c.toString()); // print out with Override
																						// string
				System.out.println();
			} else if (creation.equalsIgnoreCase("e")) {
				Employer e = new Employer();
				String social = Console.getString("SSN:     "); // prompt for SSN
				e.setFirstName(fn);
				e.setLastName(ln);
				e.setSsn(social);
				System.out.println();
				System.out.println("You entered a new employer" + "\n" + e.toString());
				System.out.println();
			} else {
				System.out.println("This entry is required. Try again");
			}

			// Ask user if they want to continue
			choice = Console.getString("Continue? (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				choice = sc.nextLine();
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Goodbye");
			} else {
				System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
			}
			System.out.println();
		}
	}
}
