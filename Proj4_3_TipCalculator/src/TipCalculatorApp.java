import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Tip Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		BigDecimal tip1 = new BigDecimal(.15);
		BigDecimal tip2 = new BigDecimal(.20);
		BigDecimal tip3 = new BigDecimal(.25);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Cost of Meal: ");
			BigDecimal mealCost = new BigDecimal(sc.next());
			System.out.println();

			BigDecimal tipAmount1 = mealCost.multiply(tip1).setScale(2, RoundingMode.HALF_UP);
			BigDecimal tipAmount2 = mealCost.multiply(tip2).setScale(2, RoundingMode.HALF_UP);
			BigDecimal tipAmount3 = mealCost.multiply(tip3).setScale(2, RoundingMode.HALF_UP);

			System.out.println("15%" + "\r" + "Tip Amount:" + "$" + (tipAmount1) + "\r" + "Total Amount:" + "$"
					+ mealCost.add(tipAmount1));
			System.out.println();
			System.out.println("20%" + "\r" + "Tip Amount:" + "$" + (tipAmount2) + "\r" + "Total Amount:" + "$"
					+ mealCost.add(tipAmount2));
			System.out.println();
			System.out.println("25%" + "\r" + "Tip Amount:" + "$" + (tipAmount3) + "\r" + "Total Amount:" + "$"
					+ mealCost.add(tipAmount3));
			System.out.println();

			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}
