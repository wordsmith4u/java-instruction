
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountriesIO {

	private final String inputFilename = "countries.txt";

	public List<String> getCountries() {

		List<String> countries = new ArrayList<>();

		try (BufferedReader in = new BufferedReader(new FileReader(inputFilename))) {
			String country = in.readLine();
			while (country != null) {
				countries.add(country);
				country = in.readLine();
			}
		} catch (IOException e) {
			System.err.println("Caught IOException in getCountries(). Msg: " + e.getMessage());
		}

		return countries;
	}

	public boolean saveCountries(List<String> countries) {
		return true;
	}

}