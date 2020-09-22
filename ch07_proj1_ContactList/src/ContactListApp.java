import java.util.Scanner;

public class ContactListApp {

	private static void printWelcomeMessage() {
		System.out.println("Welcome to the Contact List application");
		System.out.println();
	}

	public static void main(String[] args) {
		printWelcomeMessage();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get the input from the user
			String firstName = Console.getString("Enter first name:  ");
			String lastName = Console.getString("Enter last name: ");
			String email = Console.getString("Enter email:     ");
			String phone = Console.getString("Enter phone:     ");

			// Create Objects
			// ContactList contact = new ContactList();
			// contact.setFirstName(firstName);
			// contact.setLastName(lastName);
			// contact.setEmail(email);
			// contact.setPhone(phone);

			ContactList contact = new ContactList(firstName, lastName, email, phone);

			// display the output
			System.out.println(contact.displayContact());
			System.out.println();

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
		}
	}
}
