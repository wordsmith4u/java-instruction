public class CustomerTypeApp {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Customer Type Test application\n");

		// get and display the discount percent for a customer type
		// display the value of the toString method of a customer type
		CustomerType ct = CustomerType.TRADE;

		double discPer = getDiscountPercent(ct);

		System.out.println(discPer);
	}

	// Method for Enum
	public static double getDiscountPercent(CustomerType cusType) {
		switch (cusType) {
		case RETAIL:
			return 0.1;
		case TRADE:
			return 0.3;
		case COLLEGE:
			return 0.2;
		default: // Shouldn't happen
			return 0.0;
		}
	}
}
