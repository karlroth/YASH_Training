/*
* Program to return the 10th value in the fibonacci sequence, using recursion. 
*/

class Fibonacci {

	public static void main(String[] args){
		int result = fibonacci(10);
		System.out.println(result);
	}

	static int fibonacci(int n) {
		if(n < 0) {
			System.out.println("Input to fibonacci() must be greater than or equal to one.");
			return 0;
		}
		else {
			return fib(n);
		}
	}

	static int fib(int n){
		if(n == 0){
			return 0;
		}
		else if(n == 1){
			return 1;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
}