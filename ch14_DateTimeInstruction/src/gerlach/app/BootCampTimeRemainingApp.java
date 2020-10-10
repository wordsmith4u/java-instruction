package gerlach.app;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class BootCampTimeRemainingApp {

	public static void main(String[] args) {

		LocalDate bootCampStart = LocalDate.of(2020, Month.AUGUST, 10);
		LocalDate bootCampGraduation = LocalDate.of(2021, Month.FEBRUARY, 24);
		LocalDate currentDate = LocalDate.now();

		long numDaysToGo = currentDate.until(bootCampGraduation, ChronoUnit.DAYS);
		long numDaysSince = ChronoUnit.DAYS.between(currentDate, bootCampStart);
		System.out.println(numDaysToGo + " days to go.");
		System.out.println(numDaysSince + " days ago");

	}

}
