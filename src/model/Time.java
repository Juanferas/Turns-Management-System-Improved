package model;
import java.time.*;

public class Time {
	
	private LocalTime systemTime;
	private LocalTime plusTime;
	private LocalTime minusTime;
	
	public Time(int hour, int minutes) {
		systemTime = LocalTime.of(hour, minutes);
		plusTime = LocalTime.of(0, 0);
		minusTime = LocalTime.of(0, 0);
	}
	
	public Time() {
		systemTime = LocalTime.now();
		plusTime = LocalTime.of(0, 0);
		minusTime = LocalTime.of(0, 0);
	}

	/**
	 * @return the systemTime
	 */
	public LocalTime getSystemTime() {
		systemTime = LocalTime.now().plusHours(plusTime.getHour()).plusMinutes(plusTime.getMinute()).minusHours(minusTime.getHour()).minusMinutes(minusTime.getMinute());
		return systemTime;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return systemTime.getHour();
	}
	
	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return systemTime.getHour();
	}
	
	/**
	 * @param plusTime the plusTime to set
	 */
	public void setPlusTime(LocalTime plusTime) {
		this.plusTime = plusTime;
	}

	/**
	 * @param minusTime the minusTime to set
	 */
	public void setMinusTime(LocalTime minusTime) {
		this.minusTime = minusTime;
	}

	/**
	 * @return the time in format hh:mm
	 */
	public String getTime() {
		systemTime = LocalTime.now().plusHours(plusTime.getHour()).plusMinutes(plusTime.getMinute()).minusHours(minusTime.getHour()).minusMinutes(minusTime.getMinute());
		return "Time: "+systemTime.toString().substring(0, systemTime.toString().indexOf("."));
	}
}
