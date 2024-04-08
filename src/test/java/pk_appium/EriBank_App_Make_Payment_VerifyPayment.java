package pk_appium;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EriBank_App_Make_Payment_VerifyPayment {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	// String am = "50";
  @Test(priority=1)
  public void EriBank_SignOn() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
	  
  }
  
  @Test(priority=2)
  public void Verify_Balance() throws InterruptedException {
	  String am = "50";
	  
	  /*wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
		
		
	  wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();*/
	  //Thread.sleep(5000);
	  String initBal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Your balance is: 100.00$']")))
			  .getAttribute("content-desc");
	  
	  System.out.println("Required result: " + initBal);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'Make Payment')]")))
		.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/phoneTextField")))
		.sendKeys("9999999999");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/nameTextField")))
		.sendKeys("Kaushik");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/amount")))
		.sendKeys(am);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryTextField")))
		.sendKeys("India");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryButton")))
		.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/sendPaymentButton")))
		.click();
	  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
		//Thread.sleep(5000);
		 String reqResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Your balance is: 50.00$']")))
				 .getAttribute("content-desc");
	  
	  System.out.println("Required result: " + reqResult);
	  System.out.println("Total count: " + reqResult);
	  int bal = Integer.parseInt(initBal.substring(17, 20)) - Integer.parseInt(am);
	  String res = String.valueOf(bal) + ".00$";
	  System.out.println("Your result: " + res);
	  
	  Assert.assertEquals("Your balance is: " + res, reqResult);
	 
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

		wait = new WebDriverWait(driver, 60);
	  
  }

  @AfterTest
  public void CloseApp() {
	  driver.quit();
	  
  }

}
