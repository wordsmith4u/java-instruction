
public class InvoiceApp {

	public static void main(String[] args) {
		System.out.println("The Invoice Total Calculator");
		System.out.println();

		String customerType = "r";
		double subtotal = 400.0;

		double discountPercent = 0.0;

		switch (customerType) {
		case "R":
		case "r":
			if (subtotal < 100) {
				discountPercent = 0.0;
			} else if (subtotal >= 100 && subtotal < 250) {
				discountPercent = 0.1;
			} else if (subtotal >= 250) {
				discountPercent = 0.2;
			}
			break;
		case "C":
		case "c":
			if (subtotal < 250) {
				discountPercent = 0.2;
			} else if (subtotal >= 250) {
				discountPercent = 0.3;
			}
			break;

		default:
			discountPercent = 0.1;
			break;
		}

		System.out.println("discountPercent = " + discountPercent);
	}
}
