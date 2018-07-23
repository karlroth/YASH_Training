

public class GarageTester {

	public static void main(String[] args) {
		
		ParkingGarage parkingGarage = new ParkingGarage();
		
		Car car = new Car();
		car.setCarNumber(3245);
		
		parkingGarage.parkCar(car);
		
		parkingGarage.printGarage();
		
		
	}
	
}
