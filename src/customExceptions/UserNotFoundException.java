package customExceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
    
    private String documentNumber;
    
    public UserNotFoundException(String documentNumber) {
        super("<<User with document number: \""+documentNumber+"\" not found>>");
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
		return documentNumber;
	}
}