
public class CheckingAccount extends Account {

	// Fields
	private double monthlyFee;

	// Constructor
	public CheckingAccount() {
		monthlyFee = 0.0;
	}

	public CheckingAccount(double initialBalance, double monthlyFee) {
		super(initialBalance);
		this.monthlyFee = monthlyFee;
	}

	// Getters
	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void applyMonthlyFee() {
		balance -= monthlyFee;
	}
}
