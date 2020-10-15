import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements DAO<Customer> {

	private List<Customer> customers = null;
	private Path customersPath = null;
	private File customersFile = null;

	private final String FIELD_SEP = "\t";

	public CustomerTextFile() {
		customersPath = Paths.get("customers.txt"); // Step 3
		customersFile = customersPath.toFile(); // Step 3

		// Read the customers from the file
		getAll();
	}

	@Override
	public List<Customer> getAll() {
		// if the customers file has already been read, don't read it again
		if (customers != null) {
			return customers;
		}

		customers = new ArrayList<>();

		// load the array list with Customer objects created from
		// the data in the file
		// Step 4
		if (Files.exists(customersPath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(customersFile))) {
				String line = in.readLine();

				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					Customer cust = new Customer(fields[0], fields[1], fields[2]);
					customers.add(cust);

					line = in.readLine();
				}
			} catch (IOException e) {
				System.out.println("Caught an IOException in getAll(). " + e);
				return null;
			}

		} else {
			System.out.println("Customer file not found at " + customersPath.toAbsolutePath());
		}
		return customers;
	}

	@Override
	public Customer get(String email) {
		for (Customer c : customers) {
			if (c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public boolean add(Customer c) {
		customers.add(c);
		return this.saveAll();
	}

	@Override
	public boolean delete(Customer c) {
		customers.remove(c);
		return this.saveAll();
	}

	@Override
	public boolean update(Customer newCustomer) {
		// get the old customer and remove it
		Customer oldCustomer = this.get(newCustomer.getEmail());
		int i = customers.indexOf(oldCustomer);
		customers.remove(i);

		// add the updated customer
		customers.add(i, newCustomer);

		return this.saveAll();
	}

	private boolean saveAll() {
		// save the Customer objects in the array list to the file. Step 5
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(customersFile)))) {
			for (Customer c : customers) {
				out.print(c.getFirstName());
				out.print(FIELD_SEP);
				out.print(c.getLastName());
				out.println(c.getEmail());
			}

		} catch (IOException e) {
			System.out.println(e);
			return false;

		}

		return true;
	}
}