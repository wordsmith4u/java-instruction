import java.util.Scanner;

public class StringApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the String App!");
		
		String firstName = "Bob";
		String lastName = "Marley";
		
		System.out.println("Hello, "+firstName+" "+lastName);
		
		String fullName = firstName;
		System.out.println("fullName = "+fullName);
		fullName = fullName + " ";
		System.out.println("fullName = "+fullName);
		fullName += lastName;
		System.out.println("fullName = "+fullName);
		
		System.out.println("This is a sentence that\n"
				+ "is on two lines");
			
		System.out.println("Enter a name:  ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("You entered: "+name);
		
		// get numbers from the user
		System.out.print("Enter a whole number  ");
		int i = sc.nextInt();
		System.out.println("you entered:  "+i);
		
		System.out.print("Enter a decimal number  ");
		double d = sc.nextDouble();
		System.out.println("you entered:  "+d);
		
		
		System.out.println("Bye");

	}

}
