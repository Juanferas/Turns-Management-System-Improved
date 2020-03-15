package model;
import java.time.*;

public class Turn implements Comparable<Turn>{

	private String turnID;
	private User user;
	private boolean inUse;
	private TurnType type;
	private String statusWhenCalled;
	private LocalTime requestedAt;

	public Turn(String turnID, User user, TurnType type, LocalTime timeRequested) {
		this.turnID = turnID;
		this.user = user;
		this.type = type;
		inUse = true;
		statusWhenCalled = "";
		requestedAt = timeRequested;
	}

	/**
	 * @return the turnID
	 */
	public String getTurnID() {
		return turnID;
	}

	/**
	 * @param turnID the turnID to set
	 */
	public void setTurnID(String turnID) {
		this.turnID = turnID;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the inUse
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * @param inUse the inUse to set
	 */
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	/**
	 * @return the type
	 */
	public TurnType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TurnType type) {
		this.type = type;
	}

	/**
	 * @return the statusWhenCalled
	 */
	public String getStatusWhenCalled() {
		return statusWhenCalled;
	}

	/**
	 * @param statusWhenCalled the statusWhenCalled to set
	 */
	public void setStatusWhenCalled(String statusWhenCalled) {
		this.statusWhenCalled = statusWhenCalled;
	}

	/**
	 * @return the requestedAt
	 */
	public LocalTime getRequestedAt() {
		return requestedAt;
	}

	/**
	 * @param requestedAt the requestedAt to set
	 */
	public void setRequestedAt(LocalTime requestedAt) {
		this.requestedAt = requestedAt;
	}

	@Override
	public int compareTo(Turn other) {
		if (turnID.compareTo(other.getTurnID())<0) {
			return -1;
		}
		else if (turnID.compareTo(other.getTurnID())>0) {
			return 1;
		}
		return 0;
	}
}
