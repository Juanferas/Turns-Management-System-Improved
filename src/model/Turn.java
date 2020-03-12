package model;

public class Turn implements Comparable {

	private String turnID;
	private User user;
	private boolean inUse;
	private TurnType type;
	private String statusWhenCalled;

	public Turn(String turnID, User user, TurnType type) {
		this.turnID = turnID;
		this.user = user;
		this.type = type;
		inUse = true;
		statusWhenCalled = "";
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

	@Override
	public int compareTo(Object other) {
		if (turnID.compareTo(((Turn)other).getTurnID())>0) {
			return 1;
		}
		else if (turnID.compareTo(((Turn)other).getTurnID())<0) {
			return -1;
		}
		return 0;
	}
}
