import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr= new FileReader(new File("test.txt"));
		char [] value=  new char[100];
		fr.read(value);
		
		String str =  new String(value);
		System.out.println(str);
		

	}

}
