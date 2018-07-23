/*
 * Author: Karl Roth
 * Date: June 27, 2018
 * 
 * Program that takes an array of numbers, and returns a new array of only the numbers divisible by 5.
 * 
 */
class DivisibleByFiveTest {
	
	public static void main(String[] args) {

		int [] numbers = {10,3,15,2,35,9,34,12,100};
		int [] results = findNumberDivisibleByFive(numbers);
		for(int number : results) {
			System.out.println(number);
		}
	}

	public static int[] findNumberDivisibleByFive(int[] numbers) {
		
		int[] temps = new int[numbers.length];
		int[] results;
		int index = 0;
		

		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i]%5 == 0){
				temps[index] = numbers[i];
				index++;
			}
		}
		
		results = new int[index];
		
		for(int i =0; i < results.length; i++) {
			results[i] = temps[i];
		}

		return results;
		
	}
}