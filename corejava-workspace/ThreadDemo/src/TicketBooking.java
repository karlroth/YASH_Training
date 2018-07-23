
public class TicketBooking implements Runnable {

	private int availableTicket = 1;
	
	@Override 
	public void run() {
		String threadName = Thread.currentThread().getName();
		bookTicket(threadName);
	}
	
	private void bookTicket(String threadName) {
		System.out.println("Availability check by : "+threadName); 
		
		synchronized (this) {
			if(availableTicket>=1) {
				System.out.println("Booking ticket for : "+threadName);
				availableTicket -= 1;
				System.out.println("Booking completed for : " +threadName);
			} else {
				System.out.println("Ticket is not available for : "+threadName);
			}
		}
	}
	
	public static void main(String[] args) {
		TicketBooking target = new TicketBooking();
		
		Thread erinThread = new Thread(target);
		Thread kanikaThread = new Thread(target);
		
		erinThread.setName("Erin");
		kanikaThread.setName("Kanika");
		
		erinThread.start();
		kanikaThread.start();
	}
}
