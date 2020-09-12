import java.util.Scanner;

public class GuessNumberApp {

	// method used for Welcome message
	private static void displayWelcome(int limit) {
		System.out.println("Guess the number!");
		System.out.println("I'm thinking of a number between 1 and " + limit);
		System.out.println();
	}

	/**
	 * Returns a random integer between 1 and limit
	 */

	public static int getRandomInt(int limit) {
		// get a random number between 1 and the limit
		double d = Math.random() * limit; // d is >= 0.0 and < limit
		int number = (int) d; // convert double to int
		number++; // int is >= 1 and <= limit
		return number;
	}

	public static void main(String[] args) {
		final int LIMIT = 10;
		displayWelcome(LIMIT);
		int number = getRandomInt(LIMIT);

		Scanner sc = new Scanner(System.in);
		int count = 1;
		while (true) {
			System.out.print("Your guess: ");
			int guess = sc.nextInt();

			if (guess < 1 || guess > LIMIT) {
				System.out.println("Invalid guess. Try again.");
				continue;
			}

			if (guess < number) {
				System.out.println("Too low.");
			} else if (guess > number) {
				System.out.println("Too high.");
			} else {
				System.out.println("You guessed it in " + count + " tries.\n");
				break;
			}
			count++;
		}
		System.out.println("Bye!");
	}
}