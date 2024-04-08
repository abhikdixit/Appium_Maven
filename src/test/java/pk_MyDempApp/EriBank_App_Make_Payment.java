package pk_MyDempApp;

import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EriBank_App_Make_Payment {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
  @Test(priority=1)
  public void EriBank_SignOn() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView\n"
						+ ""))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[3]"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
//		
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
	  
  }
  
//  @Test(priority=2)
//  public void EriBank_MakePayment() {
//	  
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.xpath("//*[contains(@text, 'Make Payment')]"))).click();
//
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/phoneTextField"))).sendKeys("123456789");
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/nameTextField"))).sendKeys("Dixit");
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/amount"))).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/countryTextField"))).sendKeys("India");
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/countryButton"))).click();
//	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1"))).click();
//	  
//	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView["+Country+"]"))).click();
//	  
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/sendPaymentButton"))).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("android:id/button1"))).click();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
//		
//	  String LoginButton=wait.until(ExpectedConditions.visibilityOfElementLocated
//				(By.id("com.experitest.ExperiBank:id/loginButton"))).getText();
//	  Assert.assertEquals("Login", LoginButton);
//		
//  }
  
  
  @Test
  public void LaunchApp() throws MalformedURLException {
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("udid", "emulator-5554");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock","true");
		//Launch Device at run time
		//caps.setCapability("avd","Nexus_6");
		caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
		caps.setCapability("appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
		caps.setCapability("noReset","false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		wait = new WebDriverWait(driver, 60);
	  
  }

  @AfterTest
  public void CloseApp() {
	//  driver.quit();
	  
  }

}
