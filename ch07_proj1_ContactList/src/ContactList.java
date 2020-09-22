
public class ContactList {

	// fields
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	// constructors
	public ContactList() {
		this("", "", "", "");
	}

	public ContactList(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	// setter and getters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	// helper method
	public String displayContact() {
		String retVal = "------------------------------------------------------\n"
				+ "--------------Current Contact-------------------------\n"
				+ "------------------------------------------------------\n" + "Name:                  "
				+ this.firstName + " " + this.lastName + "\n" + "Email Address:         " + this.email + "\n"
				+ "Phone Number:          " + this.phone + "\n"
				+ "------------------------------------------------------";
		return retVal;
	}
}
