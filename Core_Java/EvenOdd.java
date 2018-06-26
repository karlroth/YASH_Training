/*
* Program to count how many even and odd numbers are in a string of numbers.
* 
*/

class EvenOdd {
	
	public static void main(String[] args) {
		long input = 5432625987361L;
		int numEven = countEven(input);
		int numOdd = countOdd(input);

		System.out.println("There are "+numEven+" even numbers and "+numOdd+" odd nubmers");
	}

	public static int countEven(long input) {
		
		String number = Long.toString(input);

		String[] nums = number.split("");
		int numEven = 0;

		for(int i = 0; i < nums.length; i++) {
			int num = Integer.parseInt(nums[i]);
			if( num%2 == 0){
				numEven++;
			}
		}
		return numEven;
	}

	public static int countOdd(long input) {
		String number = Long.toString(input);

		String[] nums = number.split("");
		int numOdd= 0;

		for(int i = 0; i < nums.length; i++) {
			int num = Integer.parseInt(nums[i]);
			if( num%2 != 0){
				numOdd++;
			}
		}
		return numOdd;
	}
}