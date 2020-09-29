
public class Square extends Shape {

	// Fields
	private double width;

	// Constructor
	public Square(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		return width * width;
	}

}
