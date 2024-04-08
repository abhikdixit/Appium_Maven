package pk_appium;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class EriBank_App_Calling_BaseClass_CaptureScreenshot {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
  @Test(priority=1)
  public void EriBank_SignOn() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/loginbutton"))).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
	  
  }
  
  @Test(priority=2)
  public void EriBank_MakePayment() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[contains(@text, 'Make Payment')]"))).click();

	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/phoneTextField"))).sendKeys("123456789");
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/nameTextField"))).sendKeys("Dixit");
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/amount"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/countryTextField"))).sendKeys("India");
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/countryButton"))).click();
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1"))).click();
	  
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView["+Country+"]"))).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/sendPaymentButton"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("android:id/button1"))).click();
	  
		
  }
  
  
  @BeforeTest
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
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
		caps.setCapability("noReset","false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		wait = new WebDriverWait(driver, 30);
	  
  }

  @AfterMethod
  public void CallScreenshotMethod(ITestResult result) throws Exception {
	  if (ITestResult.FAILURE==result.getStatus())
		{
	  //BaseClass cls = new BaseClass();
	  BaseClass.getScreenhot(driver, result.getName());
		}
  }
  
  @AfterTest
  public void CloseApp() throws Exception {
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
		
	  String LoginButton=wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/loginButton"))).getText();
	  Assert.assertEquals("Login", LoginButton);
	  driver.quit();
  }

}
