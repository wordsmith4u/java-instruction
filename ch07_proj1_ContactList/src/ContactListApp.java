import java.util.Scanner;

public class ContactListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List application");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get the input from the user
			String firstName = Console.getString("Enter first name: ");
			String lastName = Console.getString("Enter last name: ");
			String email = Console.getString("Enter email: ");
			String phone = Console.getString("Enter phone: ");

			// get the contactList object
			ContactList contactList = new ContactList(firstName, lastName, email, phone);

			// display the output
			System.out.println();
			System.out.println("Current Contact");
			System.out.println();
			System.out.println("Name:           " + contactList.getFirstName() + " " + contactList.getLastName());
			System.out.println("Email Address:  " + contactList.getEmail());
			System.out.println("Phone Number:   " + contactList.getPhone());
			System.out.println();

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
		}
	}
}
