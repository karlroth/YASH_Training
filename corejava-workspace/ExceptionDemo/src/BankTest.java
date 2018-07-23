
public class BankTest {

	
	public static void main(String[] args) {
		
		BankService service = new BankService();
		
		try {
			service.withdraw(101, 6000);
		} 
		catch(InvalidAccountNumberException ex) {
			System.out.println(ex.getMessage());
		}
		catch(InsufficientBalanceException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
