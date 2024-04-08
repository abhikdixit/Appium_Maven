package pk_appium;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SauceLab_EriBank_App {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	
  @BeforeTest
  public void LaunchApp() throws MalformedURLException {
	  
      DesiredCapabilities caps = new DesiredCapabilities();
  	
 // Specify device and os_version for testing
      caps.setCapability("deviceName","Samsung.*Galaxy.*");
      caps.setCapability("deviceOrientation", "portrait");
      caps.setCapability("browserName", "chrome");
      caps.setCapability("platformVersion","10.0");
      caps.setCapability("platformName","Android");

		driver = new AndroidDriver<MobileElement>(new URL("https://abhikdixit:d246025c-7be6-497f-9206-2db3dd761350@ondemand.us-west-1.saucelabs.com:443/wd/hub"),caps);

	     wait = new WebDriverWait(driver, 60);
	  
  }

  @Test
  public void EriBank_SignOn() throws InterruptedException {
	  
	  System.out.println("Welcome to SFLY");
		Thread.sleep(6000);
		System.out.println("Clicked on Get Started");

		//wait.until(ExpectedConditions.visibilityOfElementLocated
		//		(By.id("com.shutterfly:id/btn_get_started"))).click();
		//----------------------------------------------------   	

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/cart_icon"))).click();
		System.out.println("Clicked on Cart icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/second_cta_button"))).click();
		//-------------------Verify User is in Sign In page-------------------
		WebElement GetSignIn = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.className("android.widget.TextView")));
		String ExpValue = GetSignIn.getText();
		Assert.assertEquals("Sign In", ExpValue);
		System.out.println(ExpValue);
		//------------------------------------------------------------------------

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/username"))).sendKeys("abhinay.dixit@hotmail.com");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/password"))).sendKeys("test@1234");

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/sign_in_button"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.shutterfly:id/empty_state_cta_button"))).click();	
  }
  
  @AfterTest
  public void CloseApp() {
	  driver.quit();
	  
  }

}
