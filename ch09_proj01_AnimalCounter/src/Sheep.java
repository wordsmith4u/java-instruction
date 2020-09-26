
public class Sheep extends Animal implements Cloneable {

	// Field
	String name;

	// Constructor
	public Sheep() {
		name = "";
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCountString() {
		return getCount() + name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
