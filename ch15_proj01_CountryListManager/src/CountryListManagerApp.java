import java.util.ArrayList;

public class CountryListManagerApp {

	private static final int COMMAND_LIST = 1;
	private static final int COMMAND_ADD = 2;
	private static final int COMMAND_EXIT = 3;

	private static void printWelcomeMessage() {
		System.out.println("Country List Manager");
		System.out.println();
		System.out.println("COMMAND MENU");
		System.out.println("1 - List Countries");
		System.out.println("2 - Add Countries");
		System.out.println("3 - Exit");

	}

	public static void main(String[] args) {

		CountryIO countryIO = new CountryIO();

		printWelcomeMessage();

		int command = 0;
		while (command != 3) {
			command = Console.getInt("Enter Menu Number: ");

			switch (command) {
			case 1:
				listCountries();
				break;

			case 2:
				addCountry();
				break;

			case 3:
				System.out.println("Goodbye.");
				break;

			default:
				System.out.println("Invalid menu number.");
				break;

			}
		}
	}

	private static void addCountry() {
		String countries = Console.getString("add countries: ");

	}

	private static void listCountries() {
		ArrayList<String> countries = countriesIO.getCountries();
		for (String country : countries) {
			System.out.println(country);
		}

	}

}
