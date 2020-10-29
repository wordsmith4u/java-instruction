package java_misc;

public class MiscApp {

	public static void main(String[] args) {
		int value1 = 10;
		int value2 = 20;

		int min;

		// if (value1 < value2) {
		// min = value1;
		// } else {
		// min = value2;
		// }

		// TERNARY STATEMENT EXAMPLE

		min = value1 < value2 ? value1 : value2;

		System.out.println("min = " + min);

		System.out.println("min of 20 and 10 = " + MathUtils.min(20, 10));

		System.out.println("max of 20 and 10 = " + MathUtils.max(20, 10));

		System.out.println(MathUtils.sum(1, 3, 2, 5, 4, 6));
		System.out.println(MathUtils.sum(1, 5, 7, 9));

		System.out.println(MathUtils.power(2, 3));

	}
}
