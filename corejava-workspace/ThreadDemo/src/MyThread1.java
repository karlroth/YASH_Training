
public class MyThread1 implements Runnable {

	public void run() {
		String threadName = Thread.currentThread().getName();
		task(threadName);
		
	}
	
	public void task(String threadName) {
		System.out.println("Hello, "+threadName+"!");
	}
	
	public void main(String[] args) {
		MyThread1 target = new MyThread1();
		
		Thread karlThread = new Thread(target);
		Thread kellyThread = new Thread(target);
		
		karlThread.setName("Karl");
		kellyThread.setName("Kelly");
		
		karlThread.start();
		kellyThread.start();
		
		
	}
	
}
