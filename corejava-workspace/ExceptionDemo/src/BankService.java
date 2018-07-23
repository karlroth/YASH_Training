
public class BankService {
	
	private int balance = 5000;
	
	public void withdraw(int accountNum, int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
	
		if(accountNum != 101) {
			throw new InvalidAccountNumberException("Invalid account number: "+accountNum);
		}
		
		if(amount > balance) {
			throw new InsufficientBalanceException("Insufficent funds. Cannot withdraw amount: $"+amount);
		}
		
		System.out.println("Current Balance: "+balance);
		balance -= amount;
		System.out.println("Remaining Balance: "+balance);
	}
}