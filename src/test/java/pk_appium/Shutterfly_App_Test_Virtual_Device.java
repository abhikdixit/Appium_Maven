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

public class Shutterfly_App_Test_Virtual_Device {
	
	public AndroidDriver driver;
    public WebDriverWait wait;
 
    @BeforeTest
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Galaxy_Nexus_7");
		caps.setCapability("udid", "emulator-5554");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("skipUnlock","true");
		//below mentioned capability to Launch Virtual Device at run time.
		caps.setCapability("avd","Galaxy_Nexus_7");
       caps.setCapability("appPackage", "com.shutterfly");
       caps.setCapability("appActivity","com.shutterfly.main.ShutterflyMainActivity");
       caps.setCapability("noReset","false");
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
       //driver = new AndroidDriver(new URL("http://127.0.0.2:3456/wd/hub"),caps);
       wait = new WebDriverWait(driver, 10);
    }
  
    @Test
    public void basicTest () throws InterruptedException {
 
    	System.out.println("Welcome to SFLY");
    	Thread.sleep(6000);
    	System.out.println("Clicked on Get Started");
    	
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
    	
    	WebElement GetAccount = wait.until(ExpectedConditions.visibilityOfElementLocated
                //(By.id("com.shutterfly:id/main_nav_tab_text")));	
    			(By.xpath("//*[contains(@text,'Account')]")));
    	GetAccount.click();
    	String ExpValueAccount = GetAccount.getText();
    	Assert.assertEquals("Account", ExpValueAccount);
    	System.out.println(ExpValueAccount);
    }
 
    @AfterTest
    public void teardown(){
    //	driver.resetApp();
        driver.quit();
    }
}
