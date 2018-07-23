import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
		User user= new User();
		user.setId(101);
		user.setName("Pankaj Sharma");
		oos.writeObject(user);
		oos.close();

	}

}
