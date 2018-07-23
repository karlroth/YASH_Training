

public class ConnectDBTest {
	public static void main(String[] args ) {
		ConnectDB driver = new OracleDriver();
	
		driver.connectTool();
		driver.useTool();
		driver.disconnectTool(); 
	}
}
