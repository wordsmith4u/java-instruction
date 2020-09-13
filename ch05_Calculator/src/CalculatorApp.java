import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String choice;

		do {
			System.out.print("Enter first operand: ");
			int leftOperator = sc.nextInt();
			System.out.print("Enter second operand: ");
			int rightOperator = sc.nextInt();
			System.out.print("Enter operation (+ - * /): ");
			String operation = sc.next();

			int answer = 0;

			switch (operation) {
			case "+":
				answer = sum(leftOperator, rightOperator);
				break;
			case "-":
				answer = difference(leftOperator, rightOperator);
				break;
			default:
				System.out.println("Unknown operation");
			}

			System.out.println("The answer is " + answer);

			// 4 + 3 = 12
			// 26 / 6 = 4

			System.out.print("Continue? (y/n) ");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));
	}

	private static int sum(int op1, int op2) {
		System.out.println("In sum method");

		int result = op1 + op2;

		return result;
	}

	private static int difference(int diffOperand1, int diffOperand2) {
		int result = diffOperand1 - diffOperand2;
		return result;
	}

}