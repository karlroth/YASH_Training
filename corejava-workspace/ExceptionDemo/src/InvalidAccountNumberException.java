
public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException() {
		
	}
	
	public InvalidAccountNumberException(String errorMessage) {
		super(errorMessage);
	}
}
