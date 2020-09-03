package ch02_StudentRegistration;

import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		// display an intro message
		System.out.println("Student Registration Form");
		System.out.println(); // print a blank line
		
		// create a scanner object
		 Scanner fName = new Scanner(System.in);  // Create a Scanner object
		    System.out.print("Enter First Name:  ");
		    String firstName = fName.nextLine();  // Read user input
		    
		  Scanner lName = new Scanner(System.in);  // Create a Scanner object
		    System.out.print("Enter Last Name:  ");
		    String lastName = lName.nextLine();  // Read user input
		    
		  Scanner bYear = new Scanner(System.in);  // Create a Scanner object
		    System.out.print("Enter year of birth:  ");
		    int birthYear = bYear.nextInt();  // Read user input
		    System.out.println(); // print a blank line
		  
		 // display output
		  System.out.println("Welcome" + " " +firstName + " " +lastName +"!");
		  System.out.println("Your registration is complete.");
		  System.out.println("Your temporary password is:" + " " + firstName + "*" + birthYear);	
	}
}
