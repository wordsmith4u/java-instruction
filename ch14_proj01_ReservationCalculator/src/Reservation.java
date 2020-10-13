import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Reservation {

	// fields
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private final double NIGHTLY_RATE = 145.0;

	// Constructors
	public Reservation() {
		arrivalDate = null;
		departureDate = null;
	}

	public Reservation(LocalDate arrivalDate, LocalDate departureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	// getters and setters
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public String getArrivalDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(arrivalDate);
		return dateFormatted;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(departureDate);
		return dateFormatted;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	// business methods
	public int getNumberOfNights() {
		return (int) arrivalDate.until(departureDate, ChronoUnit.DAYS);
	}

	public String getPricePerNightFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(NIGHTLY_RATE);
	}

	public double getTotalPrice() {
		return NIGHTLY_RATE * getNumberOfNights();
	}

	public String getTotalPriceFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(getTotalPrice());
	}

}
