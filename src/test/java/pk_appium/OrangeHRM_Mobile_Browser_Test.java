package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrangeHRM_Mobile_Browser_Test {

	
	public AndroidDriver<WebElement> driver;
	//public AndroidDriver driver;
    public WebDriverWait wait;
 
    @BeforeTest
    public void setup () throws MalformedURLException {
    
    	DesiredCapabilities  capabilities = new DesiredCapabilities();
    	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

    	capabilities.setCapability("deviceName", "Pixel");
        //Set UDID: Unique Device Identifier
    	capabilities.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("platformVersion", "7.0");
    	capabilities.setCapability("skipUnlock","true");
    	
    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    	capabilities.setCapability("chromedriverExecutable","D:\\F Drive\\Appium Training\\workspace\\Appium_DemoProject\\chromedriver.exe");
    	driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }
 
   /* @Test
    public void Login() throws InterruptedException {
  	  	driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
  		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
  		//driver.findElement(By.id("divLoginButton")).click();
  		driver.findElement(By.name("Submit")).click();
  		Thread.sleep(8000);
  		// Verify that Dashboard page displayed
  		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
  		String ExpElement = "Dashboard";
  		Assert.assertEquals(ActElement, ExpElement);
  		System.out.println(ActElement);

  		// ----------------To Verify Logout Function without using
  		// Assert----------------
  		driver.findElement(By.id("welcome")).click();
  		Thread.sleep(8000);
  		driver.findElement(By.linkText("Logout")).click();
  		Thread.sleep(8000);
  		driver.findElement(By.id("logInPanelHeading")).isDisplayed();

    }*/

 
    @Test
    public void basicTest () throws InterruptedException {
    	driver.get("https://www.google.com");
    	System.out.println("Welcome to Google");
    	String GoogleTitle = driver.getTitle();
    	System.out.println(GoogleTitle);
    	driver.findElement(By.name("q")).sendKeys("Appium",Keys.ENTER);

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
