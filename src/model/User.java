package model;
import java.util.*;

public class User {

	private String documentType;
	private String documentNumber;
	private String name, lastNames;
	private String phone;
	private String address;
	private String assignedTurn;
	private boolean hasTurn;
	private ArrayList<Turn> requestedTurns;

	public User(String documentType, String documentNumber, String name, String lastNames, String phone, String address) {
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.name = name;
		this.lastNames = lastNames;
		this.phone = phone;
		this.address = address;
		assignedTurn = "";
		hasTurn = false;
		requestedTurns = new ArrayList<Turn>();
	}

	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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
	 * @return the lastNames
	 */
	public String getLastNames() {
		return lastNames;
	}

	/**
	 * @param lastNames the lastNames to set
	 */
	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the assignedTurn
	 */
	public String getAssignedTurn() {
		return assignedTurn;
	}
	
	/**
	 * @param turn the turnID to set
	 */
	public void assignTurn(String turn) {
		assignedTurn = turn;
	}

	/**
	 * @return the hasTurn
	 */
	public boolean hasTurn() {
		return hasTurn;
	}

	/**
	 * @param hasTurn the hasTurn to set
	 */
	public void setHasTurn(boolean hasTurn) {
		this.hasTurn = hasTurn;
	}
	
	public void addRequestedTurn(Turn pTurn) {
		requestedTurns.add(pTurn);
	}

	/**
	 * @return the requestedTurns
	 */
	public ArrayList<Turn> getRequestedTurns() {
		return requestedTurns;
	}

	@Override
	public String toString() {
		return "DocumentType= " + getDocumentType() + "\nDocumentNumber= " + getDocumentNumber() + "\nName= " + getName() + " " + getLastNames() + "\nPhone= " + getPhone() + "\nAddress= " + getAddress();
	}
}
