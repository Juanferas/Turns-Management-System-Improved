package model;
import java.time.*;

public class TurnType {
	
	private String name;
	private float duration;
	
	public TurnType(String name, float duration) {
		this.name = name;
		this.duration = duration;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the duration
	 */
	public float getDuration() {
		return duration;
	}
	
	/**
	 * @return the duration in LocalTime data type
	 */
	public LocalTime getDurationInTime() {
		LocalTime durationInLocalTime = null;
		if (String.valueOf(duration).contains(".")) {
			durationInLocalTime = LocalTime.of(0, (int)duration, (int)((duration-((int)duration))*60));
		}
		else {
			durationInLocalTime = LocalTime.of(0, (int)duration);
		}
		return durationInLocalTime;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}
}
