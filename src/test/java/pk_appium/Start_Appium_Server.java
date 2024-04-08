package pk_appium;

import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.testng.annotations.Test;

public class Start_Appium_Server {
	
	public void startServer() {
		CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		cmd.addArgument("C:\\Users\\abhin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\Appium.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.2");
		cmd.addArgument("--port");
		cmd.addArgument("1234");
		
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Start_Appium_Server()
	{
		Start_Appium_Server appiumServer = new Start_Appium_Server();
		appiumServer.startServer();
		
		System.out.println("Server Started");
 
		appiumServer.stopServer();
		System.out.println("Server Stopped");
	}

}
