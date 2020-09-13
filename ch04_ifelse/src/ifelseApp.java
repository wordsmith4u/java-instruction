public class IfElseExamples {

	public static void main(String[] args) {
		double subtotal = 34.0;

		double discountPercent = 0.05;
		if (subtotal >= 100.0 && subtotal < 200.0) {
			discountPercent = 0.1;
		} else if (subtotal >= 200.0 && subtotal < 300.0) {
			discountPercent = 0.2;
		} else if (subtotal >= 300.0) {
			discountPercent = 0.3;
		}

		System.out.println("discountPercent = " + discountPercent);
	}

}