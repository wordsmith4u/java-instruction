
public class Customer extends Person {

	// Fields
	private String customerNumber;

	public Customer() {

	}

	// Constructor
	public Customer(String firstName, String lastName, String customerNumber) {
		super(firstName, lastName);
		this.customerNumber = customerNumber;
	}

	// Getter & Setter
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCustomer Number: " + customerNumber;
	}
}
