
public class OutOfMemoryErrorDemo {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("Hello");
		while(true) {
			sb.append( "Friends");
		}
		
	}
}
