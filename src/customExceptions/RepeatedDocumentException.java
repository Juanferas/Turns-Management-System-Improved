package customExceptions;

@SuppressWarnings("serial")
public class RepeatedDocumentException extends Exception {

    private String documentNumber;

    public RepeatedDocumentException(String documentNumber) {
        super("<<The document number: \""+documentNumber+"\" already exits in the system>>");
        this.documentNumber = documentNumber;
    }

	public String getDocumentNumber() {
		return documentNumber;
	}
}