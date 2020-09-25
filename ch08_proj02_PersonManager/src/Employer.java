
public class Employer extends Person {

	private String ssn;

	public Employer() {

	}

	// Constructor
	public Employer(String firstName, String lastName, String ssn) {
		super(firstName, lastName);
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		String maskedssn = "xxx-xxxx-" + ssn.substring(ssn.length() - 4);
		return super.toString() + "\n" + "SSN:  " + maskedssn;
	}

}
