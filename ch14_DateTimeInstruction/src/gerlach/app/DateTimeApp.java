package gerlach.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class DateTimeApp {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);

		LocalDate birthDate = LocalDate.of(1964, Month.JANUARY, 12);
		System.out.println(birthDate);
		System.out.println(birthDate.getMonthValue());
		System.out.println(birthDate.getMonth());
		System.out.println(birthDate.getYear());
		System.out.println(birthDate.getDayOfWeek());

		LocalDate dateFromParse = LocalDate.parse("2020-01-01");
		System.out.println(dateFromParse);

		System.out.println("Is birthDate before currentDate " + birthDate.isBefore(currentDate));
		System.out.println("birthDate compareTo currentDate " + birthDate.compareTo(currentDate));

		LocalDate halloween = LocalDate.of(2020, Month.OCTOBER, 31);
		LocalDate february = halloween.withMonth(2);
		System.out.println(february);

		LocalDate nextMonth = currentDate.plus(1, ChronoUnit.MONTHS);
		System.out.println(nextMonth + " " + nextMonth.getDayOfWeek());
		LocalDate fourWeeks = currentDate.plus(4, ChronoUnit.WEEKS);
		System.out.println(fourWeeks + " " + fourWeeks.getDayOfWeek());

		long yearsOld = birthDate.until(currentDate, ChronoUnit.YEARS);
		System.out.println(yearsOld);

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("No formatter: " + currentDateTime);

		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println("Medium Format: " + dtf.format(currentDateTime));

	}

}
