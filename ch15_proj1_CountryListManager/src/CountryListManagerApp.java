
import java.util.List;

public class CountryListManagerApp {

	private static final int COMMAND_LIST = 1;
	private static final int COMMAND_ADD = 2;
	private static final int COMMAND_EXIT = 3;

	private static void printWelcomeMessage() {
		System.out.println("Country List Manager");
		System.out.println();
		System.out.println("COMMAND MENU");
		System.out.println(COMMAND_LIST + " - List countries");
		System.out.println(COMMAND_ADD + " - Add country");
		System.out.println(COMMAND_EXIT + " - Exit");
	}

	private static void listCountries() {
		CountriesIO countriesIO = new CountriesIO();
		List<String> countries = countriesIO.getCountries();

		for (String country : countries) {
			System.out.println(country);
		}
	}

	private static void addCountry() {

	}

	public static void main(String[] args) {
		printWelcomeMessage();

		int command = -1;
		while (command != COMMAND_EXIT) {
			System.out.println();
			command = Console.getInt("Enter menu number: ");
			System.out.println();

			switch (command) {
			case COMMAND_LIST:
				listCountries();
				break;

			case COMMAND_ADD:
				addCountry();
				break;

			case COMMAND_EXIT:
				System.out.println("Goodbye.");
				break;

			default:
				System.out.println("Invalid menu number");
				break;
			}
		}
	}

}