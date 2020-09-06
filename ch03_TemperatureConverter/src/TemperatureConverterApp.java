import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Temperature Converter");
		System.out.println();

		double fahrenheit = 0;
		double celsius = 0;
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter Degrees in Fahrenheit:");
			fahrenheit = sc.nextDouble();
			celsius = (fahrenheit - 32) * (0.5556);
			celsius = (double) Math.round(celsius * 100) / 100;
			System.out.println("Degrees in Celsius:" + celsius);

			System.out.println();
			System.out.print("Continue? (y/n):");
			choice = sc.next();
			System.out.println();
		}
	}
}
