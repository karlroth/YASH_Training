


public class ParkingGarage {

	private Car[][] garage;
	private int[][] parkingSpots;
	private int[][] carIds;
	
	
	public ParkingGarage() {
		garage = createGarage();
		parkingSpots = createSpots();
		carIds = createSpots();
	}

	public static Car[][] createGarage() {
		Car[][] garage = new Car[5][];
		
		garage[0] = new Car[5];
		garage[1] = new Car[4];
		garage[2] = new Car[3];
		garage[3] = new Car[3];
		garage[4] = new Car[2];
		
		return garage;
	}
	
	public static int[][] createSpots() {
		int[][] garage = new int[5][];
		
		garage[0] = new int[5];
		garage[1] = new int[4];
		garage[2] = new int[3];
		garage[3] = new int[3];
		garage[4] = new int[2];
		
		return garage;
	}
	
	public void parkCar(Car car) {
		
		int[] index = findNextParkingSpot(parkingSpots);
		
		if(index[0] == -1) {
			System.out.println("Invalid operation. Garage is full.");
			return;
		}
		
		int floor = index[0];
		int spot = index[1];
		
		garage[floor][spot] = car;
		parkingSpots[floor][spot] = 1;
		carIds[floor][spot] = car.getCarNumber();
		
	}
	
	
	public static int[] findNextParkingSpot(int[][] parkingSpots) {
		
		int[] index = {-1,-1};
		
		for(int i = 0; i < parkingSpots.length; i++) {
			for(int j = 0; j < parkingSpots[i].length; j++) {
				if(parkingSpots[i][j] == 0) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		
		System.out.println("The parking garage is full");
		return index;
	}
	
	public void printGarage() {
		
		for(int i = 0; i < parkingSpots.length; i++) {
			for(int j = 0; j < parkingSpots[i].length; j++) {
				System.out.print(parkingSpots[i][j] + " ");
			}
			System.out.println();
		} 
	}
	
}
