import java.util.Scanner;

public class ThreadDemo {
	
	private static int num;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number greater than 0.");
		num =sc.nextInt();
		
		SquareThread squareThread = new SquareThread();
		FiboThread fiboThread = new FiboThread();
		
		squareThread.setTerm(num);
		fiboThread.setTerm(num);
		
		squareThread.start();
		fiboThread.start();
	
	}

}

class FiboThread extends Thread {

	private int num;
	
	
	public void setTerm(int num) {
		this.num=num;
	}
	
	@Override
	public void run() {
		calculateFibo(num);
	}	

	public void calculateFibo(int num) {
		/*
		int[] fibos = new int[num];
		
		fibos[0] = 0;
		fibos[1] = 1; 
		*/
		int prev1 = 1;
		int prev2 = 0;
		int current;
		
		System.out.println("Fibo-> 0");
		System.out.println("Fibo-> 1");
		
		for(int i = 1; i < num; i++) {
			
			current = prev1+prev2;
			prev2= prev1;
			prev1=current;
			System.out.println("Fibo-> "+ current);
	
		}
	}
}

class SquareThread extends Thread {
	
	private int num;
	
	public void setTerm(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		calculateSquare(num);
	}

	public void calculateSquare(int num) {

		for (int i = 1; i < num + 1; i++) {
			System.out.println("Square-> " + i * i);
		}

	}

}

