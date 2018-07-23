
public class UrlSplitter {
	
	public static void main(String[] args) {
		String url1 = "www.yash.com/students/register.do";
		String url2 = "www.yash.com/training/users/adduser.do";
		getAction(url1);
		getAction(url2);
	}
	
	public static void getAction(String url) {
		String[] output = url.split("/");
		int last = output.length - 1; 
		
		String[] action = output[last].split("\\.");
		
		
		System.out.println(action[0]);
	
	}
}
