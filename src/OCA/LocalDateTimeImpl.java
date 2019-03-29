package OCA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.stream.IntStream;

class LocalDateTimeImpl {

	public static void main(String arts[]) {
		doFunctionsForDateTime();
	}

	public static void doFunctionsForDateTime() {

		// LocalTime, CHronoUnit, Until function etc
		LocalTime now = LocalTime.of(10, 10, 10);
		LocalTime earlierTime = LocalTime.of(8, 30).withMinute(now.getMinute());
		LocalTime laterTime = LocalTime.of(12, 30).withMinute(now.getMinute());
		System.out.print(now.until(earlierTime, ChronoUnit.HOURS));
		System.out.println(now.until(laterTime, ChronoUnit.HOURS));

		// Date, Format, dateFormat
		Date date = new Date();
		DateFormat format = DateFormat.getDateInstance(DateFormat.DEFAULT);
		System.out.println(format.format(date));

		// Local Date
		LocalDate date4 = LocalDate.of(2016, Month.JANUARY, 1);
		LocalDate date2 = LocalDate.of(2017, Month.JANUARY, 1);
		LocalDateTime time1 = LocalDateTime.of(2016, Month.JANUARY, 1, 0, 0);
		LocalDateTime time2 = LocalDateTime.of(2017, Month.JANUARY, 1, 0, 0);
		// Duration dur1 = Duration.between(date1, date2);

		// Duration dur2 = Duration.between(time1, time2);

		LocalDate testDate = LocalDate.parse("2014-05-04");
		System.out.println("testDate:" + testDate);

		IntStream in = IntStream.range(1, 5);
		in.forEach(System.out::println);

		System.out.println(Float.parseFloat(new String("1.2")));
		System.out.println(Float.valueOf(new String("1.2")));

		testDate = testDate.plusDays(2);
		
		LocalDate d1 = LocalDate.of(1970, 1, 1);
		//LocalDate d2 = LocalDate.parse("1999-1-1", DateTimeFormatter.ISO_DATE);
		
		System.out.println(d1);
		//System.out.println(d2);
		
		LocalDateTime nowIt = LocalDateTime.of(2016, Month.NOVEMBER, 6, 12, 0);
		ZonedDateTime dateTime1 = ZonedDateTime.of(nowIt, ZoneId.of("US/Pacific"))
				.plus(Period.ofDays(1));
		ZonedDateTime dateTime2 = ZonedDateTime.of(nowIt, ZoneId.of("US/Pacific"))
				.plus(Duration.ofDays(1));
		System.out.println(dateTime1.getHour());
		System.out.println(dateTime2.getHour());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM",Locale.US);
		System.out.println(dateFormat.format(new Date()));
		
		Period period = Period.ofDays(30);
		Duration duration = Duration.ofDays(30);
		System.out.println("period:"+period);
		System.out.println("duration:"+duration);
		
		LocalDate date1 = LocalDate.of(2016, 1, 1);
		LocalDate lastDate = date1.minus(Period.of(1,0,0));
		System.out.println("lastDate:"+lastDate);
		
		LocalDate lastDateAnother = date1.minus(1, ChronoUnit.YEARS);
		System.out.println("lastDateAnother:"+lastDateAnother);
		
		LocalDate lastDate1 = date1.minus(365, ChronoUnit.DAYS);
		System.out.println("lastDate1:"+lastDate1);
		
		LocalDate lastDate2 = date1.minusYears(1);
		System.out.println("lastDate2:"+lastDate2);
	}
}