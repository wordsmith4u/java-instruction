
import java.util.ArrayList;

public class WizardInventoryApp {

	private static final int MAX_INVENTORY_SIZE = 4;

	public static void main(String[] args) {

		System.out.println("The Wizard Inventory Game");
		System.out.println();
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all items\n" + "grab - Grab and item\n" + "edit - Edit an item\n"
				+ "drop - Drop an item\n" + "exit - Exit program");
		System.out.println();

		ArrayList<String> menu = new ArrayList<>();
		menu.add("wooden staff");
		menu.add("wizard hat");
		menu.add("cloth shoes");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String commandCode = Console.getString("Command: ");
			if (commandCode.equalsIgnoreCase("show")) {
				for (String s : menu) {
					System.out.println(s);
				}
			} else if (commandCode.equalsIgnoreCase("drop")) {
				int code = Console.getInt("Number: ");
				String codeRemove = menu.remove(code - 1);
				System.out.println(codeRemove + " " + "was dropped.");

			} else if (commandCode.equalsIgnoreCase("grab")) {
				String newItem = Console.getString("Name: ");
				menu.add(newItem);
				System.out.println(newItem + " " + "was added.");

			} else if (menu.size() >= MAX_INVENTORY_SIZE) {
				System.out.println("You can't carry anymore items. Drop something first");
				return;

			} else if (commandCode.equalsIgnoreCase("edit")) {
				int oneBasedIndex = Console.getInt("Number: ");
				int zeroBasedIndex = oneBasedIndex - 1;

				if (zeroBasedIndex > 0 || zeroBasedIndex >= menu.size()) {
					System.out.println("Index Invalid");
					return;
				}

				String newItemName = Console.getString("Updated name: ");
				menu.set(zeroBasedIndex, newItemName);
				System.out.println(newItemName);
			}

			else {
				System.out.println("Bye");
				break;
			}
			System.out.println();
		}
	}
}
