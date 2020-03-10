package model;
import java.util.*;
import customExceptions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClientServiceTest {
	
	private ClientService serviceTest;
	
	public void setup1_UserDoesntExits_ProgramWithoutUsers() {
		serviceTest = new ClientService();
	}
	
	public void setup2_UserAlreadyExists() {
		serviceTest = new ClientService();
		serviceTest.registerUser("Identity card", "2116988965", "User2", "test", "3184567854", "");
	}
	
	public void setup3_ProgramWithUsers() {
		serviceTest = new ClientService();
		serviceTest.registerUser("Identity card", "87654321", "User3", "test", "3123456783", "");
		try {
			serviceTest.assignTurn(serviceTest.getUsers().get(0).getDocumentNumber());
		} catch (Exception e) {
			return;
		}
		serviceTest.registerUser("Identity card", "53426759", "User4", "test", "", "");
	}
	
	public String[] addUser() {
		User newUser = null;
		serviceTest.registerUser("Identity card", "12345678", "User1", "test", "", "");
		for (int i=0; i<serviceTest.getUsers().size(); i++) {
			if (serviceTest.getUsers().get(i).getDocumentNumber().contentEquals("12345678")) {
				newUser = serviceTest.getUsers().get(i);
			}
		}
		String[] newUserAttributes = {newUser.getDocumentType(), newUser.getDocumentNumber(), newUser.getName(), newUser.getLastNames(), newUser.getPhone(), newUser.getAddress()};
		return newUserAttributes;
	}
	
	public String verifyUser(String userID) {
		String msj = "";
		try{
			serviceTest.verifyID(userID);
			fail();
		}catch (Exception e) {
			msj = e.getMessage();
		}
		return msj;
	}
	
	public String findUser(String userID) {
		String msj = "";
		try {
			msj = serviceTest.findUser(userID);
		} catch (Exception e) {
			msj = e.getMessage();
		}
		return msj;
	}
	
	public String assignTurn(String userID) {
		String msj = "";
		for (int i=0; i<serviceTest.getUsers().size(); i++) {
			if (serviceTest.getUsers().get(i).getDocumentNumber().equals(userID)) {
				try {
					msj = serviceTest.assignTurn(serviceTest.getUsers().get(i).getDocumentNumber());
				} catch (Exception e) {
					msj = e.getMessage();
				}
			}
		}
		return msj;
	}
	
	public String attendTurn() {
		serviceTest.endTurn(1, serviceTest.getActualTurn());
		String msj = serviceTest.getActualTurn();
		return msj;
	}

	@Test
	void testUserCreation() {
		setup1_UserDoesntExits_ProgramWithoutUsers();
		assertEquals(Arrays.toString(new String[] {"Identity card", "12345678", "User1", "test", "Not given", "Not given"}), Arrays.toString(addUser()));
		setup2_UserAlreadyExists();
		assertEquals((new RepeatedDocumentException("2116988965")).getMessage(), verifyUser("2116988965"));
		setup3_ProgramWithUsers();
		assertEquals(Arrays.toString(new String[] {"Identity card", "12345678", "User1", "test", "Not given", "Not given"}), Arrays.toString(addUser()));
		assertEquals((new RepeatedDocumentException("53426759")).getMessage(), verifyUser("53426759"));
	}
	
	@Test
	void testFindUser() {
		setup1_UserDoesntExits_ProgramWithoutUsers();
		assertEquals((new UserNotFoundException("87654321")).getMessage(), findUser("87654321"));
		setup2_UserAlreadyExists();
		assertEquals("\n-------USER-------\nDocumentType= Identity card\nDocumentNumber= 2116988965\nName= User2 test\nPhone= 3184567854\nAddress= Not given", findUser("2116988965"));
		setup3_ProgramWithUsers();
		assertEquals("\n-------USER-------\nDocumentType= Identity card\nDocumentNumber= 53426759\nName= User4 test\nPhone= Not given\nAddress= Not given", findUser("53426759"));
		assertEquals((new UserNotFoundException("12345678")).getMessage(), findUser("12345678"));
	}
	
	@Test
	void testAssignTurn() {
		setup3_ProgramWithUsers();
		assertEquals((new UserAlreadyHasTurnException("87654321", "A00")).getMessage(), assignTurn("87654321"));
		assertEquals("<<Turn assigned correctly [A01]>>", assignTurn("53426759"));
	}
	
	@Test
	void testGenerateTurn() {
		setup2_UserAlreadyExists();
		assertEquals("<<Turn assigned correctly [A00]>>", assignTurn("2116988965"));
		setup3_ProgramWithUsers();
		assertEquals("<<Turn assigned correctly [A01]>>", assignTurn("53426759"));
		setup3_ProgramWithUsers();
		serviceTest.setLetter('D');
		serviceTest.setNum(99);
		assertEquals("<<Turn assigned correctly [E00]>>", assignTurn("53426759"));
		setup3_ProgramWithUsers();
		serviceTest.setLetter('Z');
		serviceTest.setNum(99);
		assertEquals("<<Turn assigned correctly [A00]>>", assignTurn("53426759"));
	}
	
	@Test
	void testNextTurnToAttend() {
		setup3_ProgramWithUsers();
		assertEquals("A00", serviceTest.getActualTurn());
	}
	
	@Test
	void testAttendTurn() {
		setup3_ProgramWithUsers();
		assertEquals("<<There are no turns to attend>>", attendTurn());
	}
}
