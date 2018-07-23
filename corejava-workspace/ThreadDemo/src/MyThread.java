
public class MyThread extends Thread {

	
	@Override 
	public void run() {
		String threadName = MyThread.currentThread().getName();
		task(threadName);
	}
	
	public void task(String threadName) {
		System.out.println("Hello, "+threadName+"!");
	}
	
	public static void main(String[] args ) {
		MyThread karlThread = new MyThread();
		MyThread kellyThread = new MyThread();
		
		karlThread.setName("Karl");
		kellyThread.setName("Kelly");
		
		karlThread.start(); // adding thread in pool
		kellyThread.start();	
		
	}
}
