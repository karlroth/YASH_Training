
public class ThrowDemo {
	public static void main(String[] args) {
		String userRole="Admin";
		System.out.println("--------First Line--------");
		
		try {
			if(userRole.equals("Admin")) {
				System.out.println("Welcome: "+userRole);
			}
			else {
				throw new RuntimeException("You are not allowed to enter the system");
			}
		} catch(RuntimeException ex) {
			System.out.println("Error :"+ex.getMessage());
		}
	}
}
