package gerlach.app;

public class StringApp {

	public static void main(String[] args) {
		String productCode = "java";
		System.out.println("Length of " + productCode + " is " + productCode.length());

		String name = "Martin Van Buren";
		int firstSpace = name.indexOf(" ");
		System.out.println("Found first space at index " + firstSpace);
		int secondSpace = name.indexOf(" ", firstSpace + 1);
		System.out.println("Found second space at index " + secondSpace);
		int thirdSpace = name.indexOf(" ", secondSpace + 1);
		System.out.println("Found third space at index " + thirdSpace);

		char fifthChar = name.charAt(4);
		System.out.println("The fifth character is " + fifthChar);

		String strWithSpaces = "    a   b   c ";
		String trimmed = strWithSpaces.trim();
		System.out.println("Trimmed = [" + trimmed + "]");

		String fullName = "Mike Murach";
		int spaceIndex = fullName.indexOf(" ");
		String firstName = fullName.substring(0, spaceIndex);
		String lastName = fullName.substring(spaceIndex + 1);
		System.out.println("firstName = [" + firstName + "] lastName = [" + lastName + "]");

	}

}
