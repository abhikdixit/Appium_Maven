package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class EriBank_App_Test_Device_Start_Runtime {
	
	public AndroidDriver driver;
    public WebDriverWait wait;
 
    @BeforeTest
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("udid", "emulator-5554");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock","true");
		//below mentioned capability to Launch Virtual Device at run time.
		caps.setCapability("avd","Pixel");
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
       caps.setCapability("noReset","false");
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
       //driver = new AndroidDriver(new URL("http://127.0.0.2:3456/wd/hub"),caps);
       wait = new WebDriverWait(driver, 10);
    }
  
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
  	  wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("android:id/text1"))).click();
  	  wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/sendPaymentButton"))).click();
  	  wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("android:id/button1"))).click();
  	  wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
  		
  	  String LoginButton=wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/loginButton"))).getText();
  	  Assert.assertEquals("Login", LoginButton);
  		
    }
    
 
    @AfterTest
    public void teardown(){
    //	driver.resetApp();
        driver.quit();
    }
}
