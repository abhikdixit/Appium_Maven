package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Booking_App {
	
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@Test//Main Method
	public void LoginActivity() {
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
	}
	
	@Before
	public void LaunchApp() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Galaxy_Nexus_7");
		caps.setCapability("udid", "emulator-5554");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock","true");
		//Launch Device at run time
		//caps.setCapability("avd","Galaxy_Nexus_7");
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
		caps.setCapability("noReset","false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		wait = new WebDriverWait(driver, 60);
	}
	
	  @After
	  public void CloseApp() {
		  driver.quit();
		  
	  }
}
