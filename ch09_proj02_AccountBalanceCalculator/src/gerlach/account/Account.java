package gerlach.account;
import gerlach.interfaces.Balanceable;
import gerlach.interfaces.Depositable;
import gerlach.interfaces.Withdrawable;

public class Account implements Depositable, Withdrawable, Balanceable {

	// Fields
	protected double balance;

	// Constructor--default balance
	public Account() {
		balance = 0.0;
	}

	public Account(double initialbalance) {
		balance = initialbalance;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		this.balance = balance;

	}

	@Override
	public void withdraw(double withdrawAmount) {
		balance -= withdrawAmount;

	}

	@Override
	public void deposit(double depositAmount) {
		balance += depositAmount;

	}

}
