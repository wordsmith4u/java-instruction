import java.util.Arrays;

public class SortedCustomersApp {

	public static void main(String[] args) {

		// Assign array values
		Customer[] customers = new Customer[3]; // Object, not Constructor (when dealing with arrays "[]")

		// Array values based on Customer.java input fields
		customers[0] = new Customer("anne@murach.com", "Anne", "Boehm");
		customers[1] = new Customer("joel@murach.com", "Joel", "Murach");
		customers[2] = new Customer("mike@murach.com", "Mike", "Murach");

		// How to sort array
		Arrays.sort(customers);

		// ForLoop to print output
		for (Customer c : customers) {
			System.out.println(c.getEmail() + ": " + c.getFirstName() + " " + c.getLastName());
		}
	}
}
