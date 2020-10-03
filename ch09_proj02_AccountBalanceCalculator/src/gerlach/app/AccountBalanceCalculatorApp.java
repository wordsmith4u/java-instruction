package gerlach.app;
import java.text.NumberFormat;
import java.util.Scanner;

import gerlach.account.CheckingAccount;
import gerlach.account.SavingsAccount;
import gerlach.interfaces.Depositable;
import gerlach.interfaces.Withdrawable;
import gerlach.presentation.Console;

public class AccountBalanceCalculatorApp {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Account Balance Calculator");
		System.out.println();

		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

		CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
		SavingsAccount sa = new SavingsAccount(1000.0, 1.0);

		System.out.println("Starting Balances");
		System.out.println("Checking: " + currencyFormatter.format(ca.getBalance()));
		System.out.println("Savings:  " + currencyFormatter.format(sa.getBalance()));
		System.out.println();
		System.out.println("Enter the transactions for the month");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String wOrd = Console.getString("Withdrawal or Deposit? (w/d): ");
			String chkOrSav = Console.getString("Checking or savings? (c/s) ");
			double amount = Console.getDouble("Amount?: ");

			if (wOrd.equalsIgnoreCase("w")) {
				if (chkOrSav.equalsIgnoreCase("c")) {
					withdrawAmount(ca, amount);
				} else {
					withdrawAmount(sa, amount);
				}
			} else {
				if (chkOrSav.equalsIgnoreCase("c")) {
					depositAmount(ca, amount);
				} else {
					depositAmount(sa, amount);
				}
			}

			System.out.println();
			choice = Console.getString("Continue?: (y/n)");

			ca.applyMonthlyFee();
			sa.applyMonthlyInterest();

			System.out.println("Monthly Payment and Fee");
			System.out.println("Checking Fee:    " + currencyFormatter.format(ca.getMonthlyFee()));
			System.out.println("Savings Interest Payment:    " + currencyFormatter.format(sa.getMonthlyInterestRate()));
			System.out.println();
			System.out.println("Final Balances:");
			System.out.println("Checking:    " + currencyFormatter.format(ca.getBalance()));
			System.out.println("Savings:    " + currencyFormatter.format(sa.getBalance()));
		}
	}

	private static void withdrawAmount(Withdrawable w, double amount) {
		w.withdraw(amount);
	}

	private static void depositAmount(Depositable d, double amount) {
		d.deposit(amount);
	}
}
