package pk_appium;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;


public class WindowsOS_App_Notepad {
	public static WindowsDriver<WebElement> driver=null;

	@BeforeTest
	public void setUp() throws IOException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Windows");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("deviceName", "WindowsPC");
		//caps.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		caps.setCapability("app", "notepad.exe");
		driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"),caps);
	}

	   @AfterTest
	    public void tearDown() {
	          driver.quit();
	    }

	    @Test
	    public void testWeatherApp() throws InterruptedException {
	    	Thread.sleep(5000);
	    	driver.findElementByName("Help").click();
	    	driver.findElementByName("About Notepad").click();
	    	Thread.sleep(5000);
	    	driver.findElementByName("OK").click();
	}
}
