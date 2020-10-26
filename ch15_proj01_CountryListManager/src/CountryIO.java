import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountryIO {

	private final String countriesFilename = "countries.txt";

	public ArrayList<String> getCountries() {

		ArrayList<String> countries = new ArrayList<>();

		try (BufferedReader in = new BufferedReader(new FileReader(countriesFilename))) {
			String line = in.readLine();
			while (line != null) {
				countries.add(line);
				line = in.readLine();
			}

		} catch (IOException e) {
			System.err.println("Caught IOException in getCountries(). Msg: " + e.getMessage());
		}

		return countries;
	}

	public boolean saveCountries(ArrayList<String> countries) {
		return true;
	}

}
