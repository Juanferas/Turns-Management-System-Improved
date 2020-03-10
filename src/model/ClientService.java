package model;
import java.util.*;
import customExceptions.*;
import java.time.*;

public class ClientService {

    private char letter;
	private int num;
    private ArrayList<User> users;
	private ArrayList<Turn> actualTurns;
	private ArrayList<Turn> attendedTurns;
	private ArrayList<Turn> notAttendedTurns;
	private ArrayList<TurnType> turnTypes;

    public ClientService() {
        letter = 'A';
		num = -1;
		users = new ArrayList<User>();
		actualTurns = new ArrayList<Turn>();
		attendedTurns = new ArrayList<Turn>();
		notAttendedTurns = new ArrayList<Turn>();
		turnTypes = new ArrayList<TurnType>();
    }

    /**
	 * @return the letter
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}

	/**
	 * @return the number
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the number to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * @return the actualTurns
	 */
	public ArrayList<Turn> getActualTurns() {
		return actualTurns;
	}

	/**
	 * @param actualTurns the actualTurns to set
	 */
	public void setActualTurns(ArrayList<Turn> actualTurns) {
		this.actualTurns = actualTurns;
	}

	/**
	 * @return the attendedTurns
	 */
	public ArrayList<Turn> getAttendedTurns() {
		return attendedTurns;
	}

	/**
	 * @param attendedTurns the attendedTurns to set
	 */
	public void setAttendedTurns(ArrayList<Turn> attendedTurns) {
		this.attendedTurns = attendedTurns;
	}

	/**
	 * @return the notAttendedTurns
	 */
	public ArrayList<Turn> getNotAttendedTurns() {
		return notAttendedTurns;
	}

	/**
	 * @param notAttendedTurns the notAttendedTurns to set
	 */
	public void setNotAttendedTurns(ArrayList<Turn> notAttendedTurns) {
		this.notAttendedTurns = notAttendedTurns;
	}

	/**
	 * This method receives a document number to verify if its exists in the system.
	 * <b>pre:</b> An ArrayList that stores the users in the system has already been created.
	 * <b>post:</b> It is known if the document number is repeated or not.
	 * @param documentNumber is a String that corresponds to the document number to verify.
	 * @return String that indicates if the document number is accepted or not.
	 * @throws RepeatedDocumentException
	 */
	public String verifyID(String documentNumber) throws RepeatedDocumentException{
        for (int i = 0; i<users.size(); i++) {
			if (users.get(i).getDocumentNumber().equals(documentNumber)) {
				throw new RepeatedDocumentException(documentNumber);
			}
		}
		return "ok";
    }

	/**
	 * This method receives the attributes of an user in order to register it in the system.
	 * <b>pre:</b> An ArrayList that stores the users in the system has already been created.
	 * <b>post:</b> A new user has been created and added to the system.
	 * @param documentType is a String that corresponds to the document type of the user to add.
	 * @param documentNumber is a String that corresponds to the document number to verify.
	 * @param name is a String that corresponds to the name of the user to add.
	 * @param lastNames is a String that corresponds to the last names of the user to add.
	 * @param phone is a String that corresponds to the phone of the user to add.
	 * @param address is a String that corresponds to the address of the user to add.
	 */
    public void registerUser(String documentType, String documentNumber, String name, String lastNames, String phone, String address) {
        if (phone.equals(""))
            phone = "Not given";
        if (address.equals(""))
            address = "Not given";
        users.add(new User(documentType, documentNumber, name, lastNames, phone, address));
    }

    /**
     * This method receives the id of an user in order to search it in the system and return its info.
     * <b>pre:</b> An ArrayList that stores the users in the system has already been created.
	 * <b>post:</b> The information of the desired user is returned in a String.
     * @param id is a String that correspond to the user id to search.
     * @return String with the information of the found user.
     * @throws UserNotFoundException
     */
	public String findUser(String id) throws UserNotFoundException{
		String userFound = "";
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getDocumentNumber().equals(id)) {
				userFound = "\n-------USER-------\n"+users.get(i).toString();
			}
		}
		if (userFound.equals("")) {
			throw new UserNotFoundException(id);
		}
		else {
			return userFound;
		}
	}

	/**
	 * This method receives the id of an user in order to register him a turn.
     * <b>pre:</b> An ArrayList that stores the users in the system has already been created.
	 * <b>post:</b> Next turn available is correctly assigned to the desired user.
	 * @param id is a String that correspond to the user id to register a turn.
	 * @return String indicating that the turn has been correctly assigned and its number.
	 * @throws UserAlreadyHasTurnException
	 */
    public String assignTurn(String id, int turnType) throws UserAlreadyHasTurnException{
		String turn = "";
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getDocumentNumber().equals(id)) {
				if (users.get(i).hasTurn()) {
					throw new UserAlreadyHasTurnException(id, users.get(i).getAssignedTurn());
				}
				else {
					turn = nextTurn();
					users.get(i).assignTurn(turn);
					actualTurns.add(new Turn(turn, users.get(i), turnTypes.get(turnType)));
				}
			}
		}
		return "<<Turn assigned correctly ["+turn+"] type: "+turnTypes.get(turnType).getName()+" - duration: "+turnTypes.get(turnType).getDuration()+" minutes>>";
	}

    /**
     * This method generates the number of the next turn available and returns it.
     * <b>pre:</b> Global variables num (turn's number) and letter (turn's letter) have already been created.
	 * <b>post:</b> Next turn available is correctly generated and returned.
     * @return Next turn available.
     */
	public String nextTurn() {
		String turn = "";
		num ++;
		if (num==100 && letter!='Z') {
			letter += 1;
			num = 0;
			turn = letter+"0"+String.valueOf(num);
		}
		else if (num==100 && letter=='Z') {
			letter = 'A';
			num = 0;
			turn = letter+"0"+String.valueOf(num);
		}
		else if (num>10) {
			turn = letter+String.valueOf(num);
		}
		else {
			turn = letter+"0"+String.valueOf(num);
		}
		return turn;
	}

	/**
	 * This method finds the actual turn to attend and returns it.
	 * <b>pre:</b> An ArrayList that stores the actual turns has already been created.
	 * <b>post:</b> It is know which is the actual turn to attend.
	 * @return actual turn to attend.
	 */
	public String getActualTurn() {
		String turnID = "";
		if (actualTurns.size()==0) {
			turnID = "<<There are no turns to attend>>";
		}
		else {
			turnID = actualTurns.get(0).getTurnID();
			notAttendedTurns.add(actualTurns.get(0));
			actualTurns.remove(0);
		}
		return turnID;
	}

	/**
	 * This method ends a turn and places it where it corresponds.
	 * <b>pre:</b> ArrayLists that stores the attended turns and not attended turns have already been created.
	 * <b>post:</b> A given turn is ended and placed where it corresponds.
	 * @param op is an int that corresponds to the option chose by the user.
	 * @param turnID is a String that corresponds to the turn id to end.
	 */
	public void endTurn(int op, String turnID) {
		Turn pturn = null;
		for (int i=0; i<notAttendedTurns.size(); i++) {
			if (notAttendedTurns.get(i).getTurnID()==(turnID)) {
				notAttendedTurns.get(i).setInUse(false);
				notAttendedTurns.get(i).getUser().setHasTurn(false);
				notAttendedTurns.get(i).getUser().assignTurn("");
				pturn = notAttendedTurns.get(i);
				break;
			}
		}
		if (op==1) {
			notAttendedTurns.remove(pturn);
			attendedTurns.add(pturn);
		}
	}

	public String addNewTypeOfTurn(String name, String dur) {
		String msj = "";
		float duration = Float.parseFloat(dur);
		/*
		LocalTime duration;
		if (dur.contains(".")) {
			duration = LocalTime.of(0, Integer.parseInt(dur.split(".")[0]), Integer.parseInt(dur.split(".")[1]));
		}
		else {
			duration = LocalTime.of(0, Integer.parseInt(dur.split(".")[0]));
		}
		*/
		for (int i=0; i<turnTypes.size(); i++) {
			if (turnTypes.get(i).getName().equals(name)) {
				msj = "<<A turn type with this name already exists>>";
			}
		}
		if (msj=="") {
			turnTypes.add(new TurnType(name, duration));
			msj = "<<New type of turn correctly added>>";
		}
		return msj;
	}
	
	public String typesOfTurns() {
		String types = "";
		for (int i=0; i<turnTypes.size(); i++) {
			types += "["+(i+1)+"] "+turnTypes.get(i).getName() + " " + turnTypes.get(i).getDuration() + " minutes.";
		}
		return (types!="")?types:"<<There are no types of turns added yet>>";
	}
}