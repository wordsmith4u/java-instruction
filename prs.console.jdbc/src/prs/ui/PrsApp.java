package prs.ui;

import java.sql.SQLException;
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

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome to the PRS App");
		System.out.println();

		System.out.println("COMMANDS");
		System.out.println("logout - Logout");
		System.out.println("login - Login");
		System.out.println("prod_la - List all products");
		System.out.println("vend_la - List all vendors");
		System.out.println("li_la - List all Line Items");
		System.out.println("req_la - List all requests");
		System.out.println("user_la - List all users");
		System.out.println("user_au - Add user");
		System.out.println("vend_av - Add vendor");
		System.out.println("prod_ap - Add product");
		System.out.println("li_ai - Add Line Item");
		System.out.println("req_ar - Add request");
		System.out.println("prod_dp - Delete product");
		System.out.println("vend_dv - Delete vendor");
		System.out.println("exit - Exit the application");
		System.out.println();

		User authenticatedUser = null;

		ProductDb productDb = new ProductDb();
		RequestDb requestDb = new RequestDb();
		UserDb userDb = new UserDb();
		VendorDb vendorDb = new VendorDb();

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");

			if (command.equalsIgnoreCase("login")) {
				authenticatedUser = login();

				if (authenticatedUser == null) {
					System.out.println("Username / password not found");
				} else {
					System.out.println("Welcome, " + authenticatedUser.getFirstName());
				}

			} else if (command.equalsIgnoreCase("logout")) {
				authenticatedUser = null;
			} else if (authenticatedUser != null) {

				switch (command.toLowerCase()) {
				case "prod_la":
					listProducts();
					break;

				case "vend_la":
					listVendors();
					break;

				case "prod_ap":
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

				case "prod_dp":
					int idToDel = Console.getInt("Product ID to Delete: ");
					if (productDb.delete(idToDel)) {
						System.out.println("Product Deleted");
					} else {
						System.out.println("Error Deleting Product");
					}
					break;

				case "vend_dv":
					int venIdToDel = Console.getInt("Vendor ID to Delete: ");
					if (vendorDb.delete(venIdToDel)) {
						System.out.println("Vendor Deleted");
					} else {
						System.out.println("Error Deleting Vendor");
					}
					break;

				case "req_ar":
					int newReqId = Console.getInt("ID: ");
					int newUserId = Console.getInt("UserID: ");
					String newDescription = Console.getString("Description: ");
					String newJustification = Console.getString("Justification: ");
					String newDateNeeded = Console.getString("Date Needed: ");
					String newDeliveryMode = Console.getString("Delivery Mode: ");
					String newStatus = Console.getString("Status: ");
					double newTotal = Console.getDouble("Total: ");
					String newSubmittedDate = Console.getString("Submitted Date: ");
					String newReasonForRejection = Console.getString("Reason For Rejection: ");

					Request newRequest = new Request(0, newUserId, newDescription, newJustification, newDateNeeded,
							newDeliveryMode, newStatus, newTotal, newSubmittedDate, newReasonForRejection);

					if (requestDb.add(newRequest)) {
						System.out.println("Request Added Successfully");
					} else {
						System.out.println("Error Adding Request");
					}
					break;

				case "vend_av":
					int newVendId = Console.getInt("ID: ");
					String newCode = Console.getString("Code: ");
					String newVenName = Console.getString("Name: ");
					String newAddress = Console.getString("Address: ");
					String newCity = Console.getString("City: ");
					String newState = Console.getString("Delivery State: ");
					String newZip = Console.getString("Zip: ");
					String newPhoneNumber = Console.getString("Phone Number: ");
					String newEmail = Console.getString("Email: ");

					Vendor newVendor = new Vendor(0, newCode, newVenName, newAddress, newCity, newState, newZip,
							newPhoneNumber, newEmail);

					if (vendorDb.add(newVendor)) {
						System.out.println("Vendor Added Successfully");
					} else {
						System.out.println("Error Adding Vendor");
					}
					break;

				case "li_ai":
					int newLiId = Console.getInt("ID: ");
					int newRequestId = Console.getInt("RequestID: ");
					int newProductId = Console.getInt("ProductID: ");
					int newQuantity = Console.getInt("Quantity: ");

					LineItem newLineItem = new LineItem(0, newRequestId, newProductId, newQuantity);

					if (LineItemDb.add(newLineItem)) {
						System.out.println("LineItem Added Successfully");
					} else {
						System.out.println("Error Adding LineItem");
					}
					break;

				case "user_au":
					int newUsersId = Console.getInt("ID: ");
					String newUserName = Console.getString("User Name: ");
					String newPassword = Console.getString("Password: ");
					String newFirstName = Console.getString("First Name: ");
					String newLastName = Console.getString("Last Name: ");
					String newUserPhoneNumber = Console.getString("Phone Number: ");
					String newUserEmail = Console.getString("Email: ");
					boolean newIsReviewer = Console.getBoolean("Is Reviewer: ");
					boolean newIsAdmin = Console.getBoolean("Is Admin: ");

					User newUser = new User(0, newUserName, newPassword, newFirstName, newLastName, newUserPhoneNumber,
							newUserEmail, newIsReviewer, newIsAdmin);

					if (userDb.add(newUser)) {
						System.out.println("User Added Successfully");
					} else {
						System.out.println("Error Adding User");
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
			} else {
				System.out.println("Must login to perform this action");
			}
		}

	}

	private static User login() throws SQLException {
		try {
			String userName = Console.getString("User Name: ");
			String password = Console.getString("Password ");

			UserDb userDb = new UserDb();
			User user = userDb.authenticateUser(userName, password);

			return user;

		} catch (PrsDataException e) {
			System.err.println("Error loggin in. Msg: " + e.getMessage());
			return null;
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
