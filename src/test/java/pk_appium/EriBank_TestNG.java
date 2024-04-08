package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
/*import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;*/

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EriBank_TestNG {

	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@Test//Main Method
	public void Login() {
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
	}
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_6");
		caps.setCapability("udid", "emulator-5556");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("skipUnlock","true");
		//Launch Device at run time
		//caps.setCapability("avd","Galaxy_Nexus_7");
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
		caps.setCapability("noReset","false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		wait = new WebDriverWait(driver, 60);
	}
	
	  @AfterTest
	  public void CloseApp() {
		  driver.quit();
		  
	  }
}
