/* 
* Program to compute the value of the following series:
	1 + 2/2! - 3/3! + 4/4! - 5/5! + ... + n/n!

*/
class Series {
	
	public static void main(String[] args) {
		float result = series(5);
		System.out.println(result);
	}

	/*
	* Wrapper function to check for non-negative input
	*/
	public static float series(int n) {
		if(n < 0) {
			System.out.println("The input to Series must be greater than or equal to 0");
			return 0;
		}
		else {
			return ser(n);
		}
	}

	/*
	* Function to calculate the series recursively 
	*/
	static float ser(int n) {
		
		if(n == 0){
			return 0;
		}
		else if(n == 1){
			return 1;
		}
		else {
			return (float) parity(n)*n/factorial(n) + ser(n-1);
		}
	}

	/*
	* returns the factorial of n
	*/	
	static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}

	/*
	* returns 1 for even numbers and -1 for odd numbers
	*/
	static int parity(int n) {
		if(n%2 == 0) {
			return 1;
		}
		else {
			return -1;
		}
	}
}