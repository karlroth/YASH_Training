
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
		
	}
	
	public InsufficientBalanceException(String errorMessage) {
		super(errorMessage);
	}
}

