package model;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
	
	private LocalDate systemDate;

	public Date(int month, int day, int year) {
		systemDate = LocalDate.of(year, month, day);
	}
	
	public Date() {
		systemDate = LocalDate.now();
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return systemDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	/**
	 * @return the day
	 */
	public int getDay() {
		return systemDate.getDayOfMonth();
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return systemDate.getYear();
	}
	
	/**
	 * @return the date in format mm/dd/yy
	 */
	public String getDate() {
		return "Date: "+getMonth()+"/"+getDay()+"/"+getYear();
	}
}
