package model;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
	
	private LocalDate systemDate;
	private int daysToSub;
	private int daysToSum;
	private int monthsToSub;
	private int monthsToSum;
	private int yearsToSub;
	private int yearsToSum;

	public Date(int month, int day, int year) {
		systemDate = LocalDate.of(year, month, day);
		daysToSub = 0;
		daysToSum = 0;
		monthsToSub = 0;
		monthsToSum = 0;
		yearsToSub = 0;
		yearsToSum = 0;
	}
	
	public Date() {
		systemDate = LocalDate.now();
		daysToSub = 0;
		daysToSum = 0;
		monthsToSub = 0;
		monthsToSum = 0;
		yearsToSub = 0;
		yearsToSum = 0;
	}
	
	/**
	 * @return the systemDate
	 */
	public LocalDate getSystemDate() {
		systemDate = LocalDate.now();
		systemDate = (daysToSub!=0)?systemDate.minusDays(daysToSub):(daysToSum!=0)?systemDate.plusDays(daysToSum):systemDate;
		systemDate = (monthsToSub!=0)?systemDate.minusMonths(monthsToSub):(monthsToSum!=0)?systemDate.plusMonths(monthsToSum):systemDate;
		systemDate = (yearsToSub!=0)?systemDate.minusYears(yearsToSub):(yearsToSum!=0)?systemDate.plusYears(yearsToSum):systemDate;
		return systemDate;
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
	 * @param daysToSub the daysToSub to set
	 */
	public void setDaysToSub(int daysToSub) {
		this.daysToSub = daysToSub;
	}

	/**
	 * @param daysToSum the daysToSum to set
	 */
	public void setDaysToSum(int daysToSum) {
		this.daysToSum = daysToSum;
	}

	/**
	 * @param monthsToSub the monthsToSub to set
	 */
	public void setMonthsToSub(int monthsToSub) {
		this.monthsToSub = monthsToSub;
	}

	/**
	 * @param monthsToSum the monthsToSum to set
	 */
	public void setMonthsToSum(int monthsToSum) {
		this.monthsToSum = monthsToSum;
	}

	/**
	 * @param yearsToSub the yearsToSub to set
	 */
	public void setYearsToSub(int yearsToSub) {
		this.yearsToSub = yearsToSub;
	}

	/**
	 * @param yearsToSum the yearsToSum to set
	 */
	public void setYearsToSum(int yearsToSum) {
		this.yearsToSum = yearsToSum;
	}

	/**
	 * @return the date in format mm/dd/yy
	 */
	public String getDate() {
		systemDate = LocalDate.now();
		systemDate = (daysToSub!=0)?systemDate.minusDays(daysToSub):(daysToSum!=0)?systemDate.plusDays(daysToSum):systemDate;
		systemDate = (monthsToSub!=0)?systemDate.minusMonths(monthsToSub):(monthsToSum!=0)?systemDate.plusMonths(monthsToSum):systemDate;
		systemDate = (yearsToSub!=0)?systemDate.minusYears(yearsToSub):(yearsToSum!=0)?systemDate.plusYears(yearsToSum):systemDate;
		return "Date: "+getMonth()+"/"+getDay()+"/"+getYear();
	}
}
