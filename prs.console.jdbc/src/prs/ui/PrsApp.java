package prs.ui;

import java.util.List;
import prs.business.LineItem;
import prs.business.Product;
import prs.business.Request;
import prs.business.User;
import prs.business.Vendor;
import prs.db.LineItemDb;
import prs.db.ProductDb;
import prs.db.RequestDb;
import prs.db.UserDb;
import prs.db.VendorDb;

public class PrsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS App");
		System.out.println();

		System.out.println("COMMANDS");
		System.out.println("prod_la - List all products");
		System.out.println("vend_la - List all vendors");
		System.out.println("li_la - List all Line Items");
		System.out.println("req_la - List all requests");
		System.out.println("user_la - List all users");
		System.out.println("prod_ap - Add product");
		System.out.println("exit - Exit the application");
		System.out.println();

		ProductDb productDb = new ProductDb();

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");

			switch (command.toLowerCase()) {
			case "prod_la":
				listProducts();
				break;

			case "vend_la":
				listVendors();
				break;

			case "ap":
				int newId = Console.getInt("ID: ");
				int newVendorId = Console.getInt("VendorID: ");
				String newPartNumber = Console.getString("PartNumber: ");
				String newName = Console.getString("Name: ");
				double newPrice = Console.getDouble("Price: ");
				String newUnit = Console.getString("Unit: ");
				String newPhotoPath = Console.getString("PhotoPath: ");

				Product newProduct = new Product(0, newVendorId, newPartNumber, newName, newPrice, newUnit,
						newPhotoPath);

				if (productDb.add(newProduct)) {
					System.out.println("Product Added Successfully");
				} else {
					System.out.println("Error Adding Product");
				}
				break;

			case "req_la":
				listRequests();
				break;

			case "li_la":
				listLineItems();
				break;

			case "user_la":
				listUsers();
				break;

			case "exit":
				// Nothing to do
				break;

			default:
				System.out.println("Invalid command");
				break;

			}
		}

	}

	private static void listProducts() {
		ProductDb productDb = new ProductDb();
		List<Product> products = productDb.getAll();

		System.out.println("Products: ");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
	}

	private static void listVendors() {
		VendorDb vendorDb = new VendorDb();
		List<Vendor> vendors = vendorDb.getAll();

		System.out.println("Vendors: ");
		for (Vendor vendor : vendors) {
			System.out.println(vendor);
		}
		System.out.println();
	}

	private static void listRequests() {
		RequestDb requestDb = new RequestDb();
		List<Request> requests = requestDb.getAll();

		System.out.println("Requests: ");
		for (Request request : requests) {
			System.out.println(request);
		}
		System.out.println();
	}

	private static void listLineItems() {
		LineItemDb lineItemDb = new LineItemDb();
		List<LineItem> lineItems = lineItemDb.getAll();

		System.out.println("Line Items: ");
		for (LineItem lineItem : lineItems) {
			System.out.println(lineItem);
		}
		System.out.println();
	}

	private static void listUsers() {
		UserDb userDb = new UserDb();
		List<User> users = userDb.getAll();

		System.out.println("Users: ");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println();
	}

}
