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
	 * @return the time in format hh:mm
	 */
	public String getTime() {
		systemTime = LocalTime.now().plusHours(plusTime.getHour()).plusMinutes(plusTime.getMinute()).minusHours(minusTime.getHour()).minusMinutes(minusTime.getMinute());
		return "Time: "+systemTime.toString();
	}
}
