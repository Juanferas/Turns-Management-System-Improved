package customExceptions;

@SuppressWarnings("serial")
public class UserAlreadyHasTurnException extends Exception {
    
    private String documentNumber;
    
    public UserAlreadyHasTurnException(String documentNumber, String turnID) {
        super("<<User with document number: \""+documentNumber+"\" already has a turn assigned ["+turnID+"]>>");
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
		return documentNumber;
	}
}