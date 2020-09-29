import java.util.Scanner;

public class AreaCalculatorApp {

	private static void printArea(String shapeName, Shape shape) {
		System.out.println("The area of the " + shapeName + " you entered is " + shape.getArea());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String csr = Console.getString("Calculate area of a circle, square, or rectangle? (c/s/r): ");

			switch (csr) {
			case "c":
			case "C":
				double radius = Console.getDouble("Enter radius: ");
				Circle circle = new Circle(radius);
				printArea("Circle", circle);
				break;

			case "s":
			case "S":
				double width = Console.getDouble("Enter width: ");
				Square square = new Square(width);
				printArea("Square", square);
				System.out.println();
				break;

			case "r":
			case "R":
				width = Console.getDouble("Enter width: ");
				double height = Console.getDouble("Enter heigth: ");
				Rectangle rectangle = new Rectangle(width, height);
				printArea("Rectangle", rectangle);
				System.out.println();
				break;
			}
			choice = Console.getString("Continue? (y/n): ");
		}
	}
}
