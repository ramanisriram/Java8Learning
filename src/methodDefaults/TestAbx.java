package methodDefaults;

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;

public abstract class TestAbx {
	public static void main(String args[]) {
		System.out.println("doint");
		System.out.println(Year.isLeap(2016));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(days > 365);
		
		cal.set(2016, 1, 1);
		days = cal.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days == 29);
	}
}