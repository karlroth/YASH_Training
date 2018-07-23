import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFileDemo {

	public static void main(String[] args) throws IOException  {
		File file = new File("test.txt");
		FileWriter fw= new FileWriter(file);
		fw.write("This is my test file");
		fw.close();
	}

}
