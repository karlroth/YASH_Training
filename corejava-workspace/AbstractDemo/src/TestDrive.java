
public class TestDrive {

	
	public static void main(String[] args) {
		Car driver = new Safari();
		
		driver.fillTank();
		driver.drive();
		driver.stop();
		
		System.out.println();
		
		Car driver2 = new Maruti800();
		
		driver2.fillTank();
		driver2.drive();
		driver2.stop();
				
	}
}

