
public class ContactList {

	// fields
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String contact;

	// constructors
	public ContactList() {
		firstName = "";
		lastName = "";
		email = "";
		phone = "";
		contact = "";
	}

	public ContactList(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	// setter and getters
	public void setFirstName(String name) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String name) {
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

	public String displayContact(String name, String email, String phone) {
		return contact;
	}
}
