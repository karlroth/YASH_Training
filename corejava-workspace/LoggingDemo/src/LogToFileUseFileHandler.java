import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogToFileUseFileHandler {

	private static Logger logger = Logger.getLogger("loggerdemo");
	public static void main(String[] args) throws SecurityException, IOException {
		logger.addHandler(new FileHandler("myOwnLog.xml"));
		logger.info("---Logging started---");
		
		try {
		 System.out.println(3/0);
		}
		catch (Exception ex) {
			logger.log(Level.SEVERE, "Divide by Zero");
		}
		logger.info("---Logging complete---");
	}
}
