import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("user.txt")));
		User user = (User)ois.readObject();
		System.out.println("id : "+user.getId());
		System.out.println("name : "+user.getName());
		ois.close();
	}

}
