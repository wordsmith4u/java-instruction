import java.text.NumberFormat;

public class Product {

	// Fields, aka member variables
	private String code;
	private String description;
	private double price;

	// Static Variables
	private static int instanceCount = 0;

	public Product() {
		// code = "";
		// description = "";
		// price = 0;
		this("", "", 0.0);

		instanceCount++;
	}

	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;

		instanceCount++;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	// Helper methods
	public String getPriceNumberFormat() {
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(2);
		number.setMaximumFractionDigits(2);
		String priceFormatted = number.format(price);
		return priceFormatted;
	}

	// Static Methods
	public static int getInstanceCount() {
		return instanceCount;
	}
}