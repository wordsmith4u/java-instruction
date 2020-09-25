import java.util.Scanner;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		System.out.println();

		Person p = new Person();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Create customer or employer? (c/e): ");
			String creation = sc.next();
			sc.nextLine();
			String fn = Console.getString("Enter first name:  ");
			String ln = Console.getString("Enter last name: ");
			System.out.println();

			if (creation.equalsIgnoreCase("c")) {
				Customer c = new Customer();
				String cNumber = Console.getString("Customer Number:     ");
				c.setCustomerNumber(cNumber);
				c.setFirstName(fn);
				c.setLastName(ln);
				System.out.println("You entered a new customer" + "\n" + c.toString());
				System.out.println();
			} else if (creation.equalsIgnoreCase("e")) {
				Employer e = new Employer();
				String social = Console.getString("SSN:     ");
				e.setFirstName(fn);
				e.setLastName(ln);
				e.setSsn(social);
				System.out.println();
				System.out.println("You entered a new employer" + "\n" + e.toString());
				System.out.println();
			} else {
				System.out.println("This entry is required. Try again");
			}

			System.out.print("Continue? (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				choice = sc.nextLine();
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Goodbye");
			} else {
				System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
				continue;
			}
			System.out.println();

		}
	}
}
